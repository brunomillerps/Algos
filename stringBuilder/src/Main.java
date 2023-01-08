package stringBuilder.src;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            slowStringManipulation("*", 100000);
        });

        Thread t2 = new Thread(() -> {
            fastStringManipulation("*", 100000);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

    private static void slowStringManipulation(String it, int howMany) {
        var start = System.currentTimeMillis();
        var result = "";
        for (int i = 0; i < howMany; i++) {
            result += it;
        }

        System.out.println("Slow execution took " + (System.currentTimeMillis() - start) + " ms");
    }

    private static void fastStringManipulation(String it, int howMany) {
        var start = System.currentTimeMillis();
        var result = new StringBuilder();
        for (int i = 0; i < howMany; i++) {
            result.append(it);
        }

        System.out.println("Fastest execution took " + (System.currentTimeMillis() - start) + " ms");
    }
}
