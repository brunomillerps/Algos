package starPattern;

public class Main {
    public static void main(String[] args) {

        var counter = 5;

        increasingTriangle(counter);
        decreasingTriangle(counter);
        rightSidedTriangle(counter);
    }

    private static void increasingTriangle(int counter) {
        for (int i = 0; i <= counter; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    private static void decreasingTriangle(int counter) {

        for (int i = 0; i <= counter; i++) {
            for (int j = i; j <= counter; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    private static void rightSidedTriangle(int counter) {
        for (int i = 0; i <= counter; i++) {
            for (int j = i; j <= counter; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}