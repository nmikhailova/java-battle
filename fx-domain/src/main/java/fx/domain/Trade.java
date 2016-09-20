package fx.domain;

import java.util.Date;

/**
 * <a href="http://developer.oanda.com/rest-live/orders/#createNewOrder">
 * Trade
 * </a>
 */
//TODO need to check (tradesClosed, tradeReduced in NewOrder)
public class Trade {
    //  following parameters in 'market' and 'marketIfTouched' order
    private int id;
    /**
     * Order id
     */
    private int units;
    /**
     * Number of units
     */
//    private Side side; /** Direction of the order */
    private float takeProfit;
    /**
     * The take-profit associated with the order, if any
     */
    private float stopLoss;
    /**
     * The stop-loss associated with the order, if any
     */
    private float trailingStop;
    /**
     * The trailing stop associated with the order, if any
     */

//  following parameters in 'marketIfTouched' order only
    private Date expiry;
    /**
     * The time the order expires (in RFC3339 format)
     */
    private float upperBound;
    /**
     * The maximum execution price associated with the order, if any
     */
    private float lowerBound;

    /**
     * The minimum execution price associated with the order, if any
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
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

    public float getTrailingStop() {
        return trailingStop;
    }

    public void setTrailingStop(float trailingStop) {
        this.trailingStop = trailingStop;
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
}
