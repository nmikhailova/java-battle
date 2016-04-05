package gadd.ForexMarket;

/**
 * Created by gadd on 26.03.16.
 */
public class Strategy {
    private Forex forexEngine;
    private double percentRange;

    public Strategy(double percentRange, Forex forexEngine) {
        this.percentRange = percentRange;
        this.forexEngine = forexEngine;
    }

    public void nextStep() {
    }

    public boolean needToSell(double buyRate) {
        try {
            return forexEngine.getRateHistory(0) > buyRate + buyRate * (percentRange / 100.0);
        } catch (RateHistoryIndexMismatchException e) {
            return false;
        } // тут никогда не будет вызвано

    }

    public boolean needToBuy() {
        int stepsBack = 5;
        double sum = 0;
        for (int i = 0; i < stepsBack; i++) {
            try {
                sum += forexEngine.getRateHistory(i);
            } catch (RateHistoryIndexMismatchException e) {
                return false;
            }
        }
        double averageRate = sum / stepsBack;
        try {
            return forexEngine.getRateHistory(0) < averageRate + averageRate * (percentRange / 100.0);
        } catch (RateHistoryIndexMismatchException e) {
            return false;
        }
    }
}
