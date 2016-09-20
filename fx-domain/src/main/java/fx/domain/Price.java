package fx.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <a href="http://developer.oanda.com/rest-live/rates/#getCurrentPrices">
 * Live price for specified instrument
 * </a>
 */
public class Price {
    private Instrument instrument;
    /**
     * Instrument to fetch prices for
     */
    private Date time;
    /**
     * Time in RFC3339 format
     */
    private BigDecimal bid;
    /**
     * A bid price is the highest price to buy cutrency
     */
    private BigDecimal ask;

    /**
     * A ask price is the lowest price to sell cutrency
     */

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

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }
}
