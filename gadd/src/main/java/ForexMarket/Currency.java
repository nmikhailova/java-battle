package ForexMarket;

/**
 * Created by gadd on 26.03.16.
 */
abstract class Currency {
    protected double amount;

    public Currency() {
        this(0);
    }

    public Currency(double amount) {
        this.amount = amount;
    }

    public void add(double amount) {
        this.amount += amount;
    }

    public void minus(double amount) {
        this.amount -= amount;
    }

    public double getAmount() {
        return amount;
    }
}

