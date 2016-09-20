package fx.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <a href="http://developer.oanda.com/rest-live/rates/#retrieveInstrumentHistory">
 * Candlestick or candle - is a type of representation of price chart information in the Forex market.
 * </a>
 * For additional information visit next links:
 * <a href="https://www.oanda.com/forex-trading/learn/intro-to-currency-trading/technical-analysis/candlesticks">English</a>
 * <a href="http://forex-markets.ru/chart-candle.html">Russian</a>
 */
public class Candle {
    private Date time;
    /**
     * time in RFC3339 format
     */
    private BigDecimal openMid;
    /**
     * opening price
     */
    private BigDecimal highMid;
    /**
     * highest price
     */
    private BigDecimal lowMid;
    /**
     * lowest price
     */
    private BigDecimal closeMid;
    /**
     * closing price
     */
    private int volume;
    private boolean complete;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public BigDecimal getOpenMid() {
        return openMid;
    }

    public void setOpenMid(BigDecimal openMid) {
        this.openMid = openMid;
    }

    public BigDecimal getHighMid() {
        return highMid;
    }

    public void setHighMid(BigDecimal highMid) {
        this.highMid = highMid;
    }

    public BigDecimal getLowMid() {
        return lowMid;
    }

    public void setLowMid(BigDecimal lowMid) {
        this.lowMid = lowMid;
    }

    public BigDecimal getCloseMid() {
        return closeMid;
    }

    public void setCloseMid(BigDecimal closeMid) {
        this.closeMid = closeMid;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
