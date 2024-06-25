package bmps.com.circuitbreaker;

import java.util.concurrent.Callable;

public class CircuitBreakerProxy {

    private final CircuitBreaker circuitBreaker;

    public CircuitBreakerProxy(CircuitBreaker circuitBreaker) {
        this.circuitBreaker = circuitBreaker;
    }

    public <T> T execute(Callable<T> apiCall) throws Exception {
        try {
            // Check circuit breaker state before making a request
            circuitBreaker.beforeRequest();

            // Execute the API call
            T result = apiCall.call();
            circuitBreaker.recordSuccess();
            return result;
        } catch (CircuitBreaker.CircuitBreakerOpenException e) {
            System.out.println(e.getMessage());
            // Handle the open circuit scenario
            throw e;
        } catch (Exception e) {
            circuitBreaker.recordFailure();
            e.printStackTrace();
            throw e;
        }
    }
}
