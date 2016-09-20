package fx.domain;

/**
 * <a href="http://developer.oanda.com/rest-live/orders/#createNewOrder">
 * The type of the order 'limit', 'stop', 'marketIfTouched' or 'market'
 * </a>
 */
public enum Type {
    LIMIT, // limit
    STOP, // stop
    MARKETIFTOUCHED, // marketIfTouched
    MARKET // market
}
