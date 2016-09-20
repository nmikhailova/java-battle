package task;

public class MyThread implements Runnable{

    private long firstNumber, lastNumber, startTime;
    public MyThread(long firstNumber, long lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
        this.startTime = System.currentTimeMillis();
    }

    public synchronized void spanOfThread(long firstNumber, long lastNumber){
        Challenge element = new Challenge();
        element.startCheck(firstNumber,lastNumber);
    }

    @Override
    public void run() {
        spanOfThread(firstNumber,lastNumber);
        System.out.println("run time of tread " + (System.currentTimeMillis() - startTime));
    }
}
