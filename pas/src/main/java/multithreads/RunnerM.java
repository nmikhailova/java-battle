package multithreads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnerM {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("multi thread examples");
        onThread();
        Thread.sleep(1000);
        onRunnable();
        Thread.sleep(1000);
        onExecutor();
    }

    private static void onExecutor() throws InterruptedException {
        System.out.println("      on single executor:");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " running");
                randomPause();
                System.out.println(Thread.currentThread().getName() + " stopped");
            }));
        }
        Thread.sleep(1000);
        executorService.shutdown();
        System.out.println("      on multi executor:");
        executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " running");
                randomPause();
                System.out.println(Thread.currentThread().getName() + " stopped");
            }));
        }
        executorService.shutdown();
    }

    private static void onRunnable() {
        System.out.println("      on Runnable");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " running");
                randomPause();
                System.out.println(Thread.currentThread().getName() + " stopped");
            }).start();
            randomPause();
        }
    }

    private static void onThread() {
        System.out.println("      on threads:");
        for (int i = 0; i < 10; i++) {
            new Job().start();
            randomPause();
        }
    }

    private static void randomPause() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Job extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " running");
            randomPause();
            System.out.println(Thread.currentThread().getName() + " stopped");
        }
    }

}
