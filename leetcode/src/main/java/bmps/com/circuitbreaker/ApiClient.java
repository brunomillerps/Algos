package bmps.com.circuitbreaker;

import java.time.Duration;
import java.util.concurrent.Callable;

public class ApiClient {

    private final CircuitBreakerManager circuitBreakerManager;

    public ApiClient() {
        this.circuitBreakerManager = new CircuitBreakerManager();
        // Register circuit breakers for different services
        circuitBreakerManager.registerCircuitBreaker("ServiceA", 3, Duration.ofSeconds(10), Duration.ofMinutes(1));
        circuitBreakerManager.registerCircuitBreaker("ServiceB", 5, Duration.ofSeconds(15), Duration.ofMinutes(2));
    }

    public void makeRequest(String serviceName) {
        try {
            Boolean success = circuitBreakerManager.execute(serviceName, (Callable<Boolean>) this::simulateApiRequest);
            if (!success) {
                // Handle the failure scenario (e.g., log the failure, retry, etc.)
                System.out.println("Request to " + serviceName + " failed.");
            }
        } catch (Exception e) {
            // Handle the exception thrown by the circuit breaker or API call
            System.out.println("Request to " + serviceName + " failed or circuit breaker is open.");
        }
    }

    private Boolean simulateApiRequest() {
        // Simulate an API request success or failure
        // In a real scenario, this will be an actual API call
        return Math.random() > 0.5;
    }

    public static void main(String[] args) {
        ApiClient client = new ApiClient();

        for (int i = 0; i < 10; i++) {
            client.makeRequest("ServiceA");
            client.makeRequest("ServiceB");
            try {
                Thread.sleep(1000); // Sleep for a second before the next request
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
