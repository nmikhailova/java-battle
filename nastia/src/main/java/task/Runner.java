package task;

import java.lang.*;

public class Runner {

    private static final int countThreads = 5;
    private static final long start = 123_456_789L;
    private static final long finish = 987_654_321L;
    public static long timeBefore, timeAfter;
    public static void main(String[] args) {

        timeBefore = System.currentTimeMillis();
        Challenge element = new Challenge();
        element.startCheck(start * 10,finish * 10);
        timeAfter = System.currentTimeMillis();
        System.out.println("run time without threads " + (timeAfter - timeBefore) + "\n");

        long firstNumber, lastNumber;
        long step = (finish - start) / countThreads * 10;
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < countThreads; i++){
            firstNumber = start * 10 + (i * step);
            lastNumber = start * 10 + (i+1) * step;
            Runnable initialData = new MyThread(firstNumber,lastNumber);
            Thread tr = new Thread(initialData);
            tr.start();
        }
    }
}
