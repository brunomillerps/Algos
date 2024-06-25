package bmps.com.dsa.maths;

public class PrimeChecker {
    public int isPrimeOrSmallestDivisor(int number) {
        // Check if number is less than 2
        if (number < 2) {
            return number; // Return the number itself if it is less than 2
        }
        // Check for factors from 2 to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                // Return the smallest divisor
                return i;
            }
        }
        // Number is prime, return 1
        return 1;
    }
}
