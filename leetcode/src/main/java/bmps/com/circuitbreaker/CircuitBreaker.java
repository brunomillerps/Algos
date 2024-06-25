package bmps.com.circuitbreaker;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class CircuitBreaker {

    private final int failureThreshold;
    private final Duration timeoutDuration;
    private final Duration retryTimePeriod;

    private AtomicInteger failureCount;
    private CircuitBreakerState state;
    private Instant lastFailureTime;

    public CircuitBreaker(int failureThreshold, Duration timeoutDuration, Duration retryTimePeriod) {
        this.failureThreshold = failureThreshold;
        this.timeoutDuration = timeoutDuration;
        this.retryTimePeriod = retryTimePeriod;

        this.failureCount = new AtomicInteger(0);
        this.state = CircuitBreakerState.CLOSED;
    }

    public synchronized void beforeRequest() throws CircuitBreakerOpenException {
        if (state == CircuitBreakerState.OPEN) {
            if (Duration.between(lastFailureTime, Instant.now()).compareTo(retryTimePeriod) > 0) {
                state = CircuitBreakerState.HALF_OPEN;
            } else {
                throw new CircuitBreakerOpenException("Circuit breaker is open. Requests are not allowed.");
            }
        }
    }

    public synchronized void recordSuccess() {
        failureCount.set(0);
        state = CircuitBreakerState.CLOSED;
    }

    public synchronized void recordFailure() {
        int failures = failureCount.incrementAndGet();
        lastFailureTime = Instant.now();

        if (failures >= failureThreshold) {
            state = CircuitBreakerState.OPEN;
        }
    }

    public enum CircuitBreakerState {
        CLOSED,
        OPEN,
        HALF_OPEN
    }

    public static class CircuitBreakerOpenException extends Exception {
        public CircuitBreakerOpenException(String message) {
            super(message);
        }
    }
}
