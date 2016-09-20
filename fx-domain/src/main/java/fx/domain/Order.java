package fx.domain;

import java.util.Date;

/**
 * <a href="http://developer.oanda.com/rest-live/orders/#getOrdersForAnAccount">
 * Order for an account
 * </a>
 */
public class Order {
    private int id;
    private Instrument instrument;
    private int units;
    private Side side;
    private Type type;
    private Date time;
    private float price;
    /**
     * If order type is 'limit', 'stop', or 'marketIfTouched'. The price where the order is set to trigger at.
     */
    private float takeProfit;
    /**
     * <a href="https://www.oanda.com/forex-trading/learn/intro-to-currency-trading/first-trade/orders">
     * The take profit price
     * </a>
     */
    private float stopLoss;
    /**
     * <a href="https://www.oanda.com/forex-trading/learn/intro-to-currency-trading/first-trade/orders">
     * The stop loss price
     * </a>
     */
    private Date expiry;
    /**
     *  If order type is 'limit', 'stop', or 'marketIfTouched'. The order expiration time in UTC.
     *  The value specified must be in a valid datetime format.
     */
    private float upperBound;
    /**
     * The maximum execution price
     */
    private float lowerBound;
    /**
     *  The minimum execution price
     */
    private float trailingStop;
    /**
     * <a href="https://www.oanda.com/forex-trading/learn/intro-to-currency-trading/first-trade/orders">
     * The trailing stop distance in pips, up to one decimal place
     * </a>
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(float takeProfit) {
        this.takeProfit = takeProfit;
    }

    public float getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(float stopLoss) {
        this.stopLoss = stopLoss;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public float getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(float upperBound) {
        this.upperBound = upperBound;
    }

    public float getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(float lowerBound) {
        this.lowerBound = lowerBound;
    }

    public float getTrailingStop() {
        return trailingStop;
    }

    public void setTrailingStop(float trailingStop) {
        this.trailingStop = trailingStop;
    }
}
