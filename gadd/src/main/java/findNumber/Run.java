package findNumber;

public class Run {
    public static void main(String[] args) {
        long startTime, stopTime;

        System.out.println("Without threads starts");
        startTime = System.currentTimeMillis();

        long result = new NumberFinderNoThreads().go(1234567890L, 9876543210L);
        if (result != 0) System.out.println(result);
        else System.out.println("Nothing found!");

        stopTime = System.currentTimeMillis();
        System.out.println("Without threads ends in " + (stopTime - startTime) + "ms");

        int numberOfThreads = 5;
        startTime = System.currentTimeMillis();
        System.out.println("\nWith " + numberOfThreads + " threads starts in " + startTime);

        long start = 123456789L, stop = 987654321L;
        long step = (stop - start) / numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            Runnable run = new NumberFinderThreads(start * 10 + step * 10 * i, start * 10 + step * 10 * (i + 1));
            new Thread(run).start();
        }
    }
}
