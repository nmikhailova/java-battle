package multithreads;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnerSync {

    private int countInt = 0;
    private volatile int countVolatile = 0;
    private AtomicInteger countAtomic = new AtomicInteger(0);
    private int countSync = 0;

    public static void main(String[] args) throws InterruptedException {
        new RunnerSync().go();
    }

    private void go() throws InterruptedException {
        Thread t1 = getThread();
        Thread t2 = getThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("int: " + countInt);
        System.out.println("volatile: " + countVolatile);
        System.out.println("atomic: " + countAtomic);
        System.out.println("synchronized: " + countSync);
    }

    private Thread getThread() {
        return new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                countInt++;
                countVolatile++;
                countAtomic.addAndGet(1);
                inc();
            }
        });
    }

    private synchronized void inc() {
        countSync++;
    }

}
