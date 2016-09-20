package findNumber;

public class NumberFinderThreads extends NumberFinderNoThreads implements Runnable {
    private long startNumber, stopNumber;
    private static boolean stopThreads = false;

    public NumberFinderThreads(long startNumber, long stopNumber) {
        this.startNumber = startNumber;
        this.stopNumber = stopNumber;
    }

    public void run() {
        long result = go(startNumber, stopNumber);
        if (result != 0) {
            stopThreads = true;
            System.out.println(result);
        }
        System.out.println("Stop time " + System.currentTimeMillis());
    }

    protected long go(long startNumber, long stopNumber) {
        for (long i = startNumber; i <= stopNumber; i += 10) {
            if (stopThreads) return 0;
            if (checkDifferentDigits(i)) {
                if (checkRule(i)) {
                    return (i);
                }
            }
        }
        return 0;
    }

}
