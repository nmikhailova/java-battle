/**
 * Created by user on 04.04.2016.
 */
public class MultiThreadSol implements Runnable {
    private long start, fin;

    MultiThreadSol(long start, long fin) {
        this.start = start;
        this.fin = fin;
    }

    @Override
    public void run() {
        OneThreadSolution sol = new OneThreadSolution();
        sol.solve(start, fin);
    }

}
