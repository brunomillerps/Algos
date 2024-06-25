package bmps.com.circuitbreaker;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class CircuitBreakerManager {

    private final Map<String, CircuitBreakerProxy> circuitBreakers = new HashMap<>();

    public void registerCircuitBreaker(String serviceName, int failureThreshold, Duration timeoutDuration, Duration retryTimePeriod) {
        CircuitBreaker circuitBreaker = new CircuitBreaker(failureThreshold, timeoutDuration, retryTimePeriod);
        CircuitBreakerProxy proxy = new CircuitBreakerProxy(circuitBreaker);
        circuitBreakers.put(serviceName, proxy);
    }

    public <T> T execute(String serviceName, Callable<T> apiCall) throws Exception {
        CircuitBreakerProxy proxy = circuitBreakers.get(serviceName);
        if (proxy == null) {
            throw new IllegalArgumentException("No circuit breaker registered for service: " + serviceName);
        }
        return proxy.execute(apiCall);
    }
}
