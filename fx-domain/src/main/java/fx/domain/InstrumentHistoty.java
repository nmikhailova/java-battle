package fx.domain;

/**
 * <a href="http://developer.oanda.com/rest-live/rates/#retrieveInstrumentHistory">
 * Get historical information on an instrument
 * </a>
 */
public class InstrumentHistoty {
    private Instrument instrument;
    /**
     * Name of the instrument to retrieve history for
     */
    private Granularity granularity;
    /**
     * The time range represented by each candlestick
     */
    private Candle candle;

    /**
     * Representation of price chart information in the Forex market
     */

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public void setGranularity(Granularity granularity) {
        this.granularity = granularity;
    }

    public Candle getCandle() {
        return candle;
    }

    public void setCandle(Candle candle) {
        this.candle = candle;
    }
}
