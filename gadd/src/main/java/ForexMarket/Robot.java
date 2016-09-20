package ForexMarket;

/**
 * Created by gadd on 26.03.16.
 */
public class    Robot {
    private Euro euro;
    private Dollar dollar;
    private Forex forexEngine;
    private Strategy strategy;

    public Robot(Euro euro, Dollar dollar, Forex forexEngine, Strategy strategy) {
        this.euro = euro;
        this.dollar = dollar;
        this.forexEngine = forexEngine;
        this.strategy = strategy;
    }

    public Robot(double dollarsAmount, Forex forexEngine, Strategy strategy) {
        euro = new Euro(0);
        dollar = new Dollar(dollarsAmount);
        this.forexEngine = forexEngine;
        this.strategy = strategy;
    }

    public void buyEuro(Dollar dollar) {
        try {
            euro.add(forexEngine.buyEuro(dollar).getAmount());
            this.dollar.minus(dollar.getAmount());
//            System.out.println("Buy " + euro.getAmount() + " \u20ac");
        } catch (UnableBuyCurrencyException e) {
            System.out.println(e);
            System.exit(-1);
        }
    }

    public void buyDollar(Euro euro) {
        try {
            dollar.add(forexEngine.buyDollar(euro).getAmount());
            this.euro.minus(euro.getAmount());
//            System.out.println("Buy " + dollar.getAmount() + " $");
        } catch (UnableBuyCurrencyException e) {
            System.out.println("UnableBuyCurrencyException");
            System.exit(-1);
        }
    }

    public double getDollarAmount() {
        return dollar.getAmount();
    }

    public double getEuroAmount() {
        return euro.getAmount();
    }

    public void start() {
        System.out.println("Start. Dollars amount is " + dollar.getAmount());

        double buyEuroRate = forexEngine.getRate();
        buyEuro(dollar);
        boolean flagToSell = false, flagToBuy = false;


        while (forexEngine.getStep() < forexEngine.getSize() - 1) {
            while (!flagToSell && (forexEngine.getStep() < forexEngine.getSize())) {
                flagToSell = strategy.needToSell(buyEuroRate);
                if (flagToSell) {
                    buyDollar(euro);
                }
                forexEngine.getRate();
            }
            flagToSell = false;

            while (!flagToBuy && (forexEngine.getStep() < forexEngine.getSize())) {
                flagToBuy = strategy.needToBuy();
                if (flagToBuy) {
                    buyEuro(dollar);
                }
                forexEngine.getRate();
            }
            flagToBuy = false;
        }

        buyDollar(euro);

        System.out.println("Stop. Dollars amount is " + dollar.getAmount());
    }

}




