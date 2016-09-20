package ForexMarket;

/**
 * Created by gadd on 26.03.16.
 */
public class Forex {
    public static final String DOLLAR = "dollar";
    public static final String EURO = "euro";

    private double[] rateArray; // array of values how much cost euro in dollars
    private int counter = 0;

    public Forex(double startRate, double percentRange, int size) {
        rateArray = new double[size];
        calculateRates(startRate, percentRange, size);
    }

    public ForexMarket.Euro buyEuro(ForexMarket.Dollar dollar) throws UnableBuyCurrencyException {
        try {
            return new ForexMarket.Euro(getConversionRate(DOLLAR) * dollar.getAmount());
        } catch (CurrencyTypeMismatchException e) {
            throw new UnableBuyCurrencyException(); //// it is possible to throw exception to the up-level????
        }
    }

    public ForexMarket.Dollar buyDollar(ForexMarket.Euro euro) throws UnableBuyCurrencyException {
        try {
            return new ForexMarket.Dollar(getConversionRate(EURO) * euro.getAmount());
        } catch (CurrencyTypeMismatchException e) {
            throw new UnableBuyCurrencyException();
        }
    }

    public double getConversionRate(String currencyType) throws CurrencyTypeMismatchException {
        switch (currencyType) {
            case DOLLAR:
                return 1.0 / getCurrentRate();
            case EURO:
                return getCurrentRate();
            default:
                throw new CurrencyTypeMismatchException();
        }
    }

    public double getRate() {
        return rateArray[++counter];
    }

    public int getSize() {
        return rateArray.length;
    }

    public int getStep() {
        return counter;
    }

    public double getRateHistory(int stepBack) throws RateHistoryIndexMismatchException {
        if (stepBack < counter) {
            return rateArray[counter - stepBack];
        } else {
            throw new RateHistoryIndexMismatchException();
        }
    }

    private double getCurrentRate() {
        return rateArray[counter];
    }

    private void calculateRates(double startRate, double percentRange, int arraySize) {
        java.util.Random rnd = new java.util.Random(378565414); // 378565414
        rateArray[0] = startRate;
        for (int i = 1; i < arraySize; i++) {
            int dynamic = rnd.nextBoolean() ? 1 : -1; // positive or negative dynamics
            double delta = dynamic * (rnd.nextDouble() * percentRange / 100.0) * rateArray[i - 1];
            rateArray[i] = rateArray[i - 1] + delta;
        }
    }

}

class CurrencyTypeMismatchException extends Exception {
}

class RateHistoryIndexMismatchException extends Exception {
}