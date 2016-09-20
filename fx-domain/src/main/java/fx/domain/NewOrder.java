package fx.domain;

import java.util.Date;

/**
 * <a href="http://developer.oanda.com/rest-live/orders/#createNewOrder">
 * New order
 * </a>
 */
public class NewOrder {
    private Instrument instrument;
    /**
     * Instrument to open the order on
     */
    private Date time;
    /**
     * Time that order was executed
     */
    private float price;
    /**
     * Trigger price of the order
     */
    private Trade tradeOpened; /*TODO need to check class naming*/
    private Trade tradesClosed; /*TODO need to check class naming*/
    private Trade tradeReduced; /*TODO need to check class naming*/

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
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

    public Trade getTradeOpened() {
        return tradeOpened;
    }

    public void setTradeOpened(Trade tradeOpened) {
        this.tradeOpened = tradeOpened;
    }

    public Trade getTradesClosed() {
        return tradesClosed;
    }

    public void setTradesClosed(Trade tradesClosed) {
        this.tradesClosed = tradesClosed;
    }

    public Trade getTradeReduced() {
        return tradeReduced;
    }

    public void setTradeReduced(Trade tradeReduced) {
        this.tradeReduced = tradeReduced;
    }
}
