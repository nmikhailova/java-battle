package fx.service;

import java.util.Map;

import fx.domain.NewOrder;
import fx.domain.Order;
import fx.domain.Orders;

/**
 * <a href="http://developer.oanda.com/rest-live/orders/">
 * Information about orders for an account
 * </a>
 */
public class OrdersService {
    /**
     * <a href="http://developer.oanda.com/rest-live/orders/#getOrdersForAnAccount">
     * Get a list of pending orders for an account
     * </a>
     *
     * @param accountID id of user's account
     * @param params    HashMap of parameters, adding to request, or null
     * @return Orders
     * @throws ServiceHttpException
     */
    public Orders getAll(int accountID, Map<String, String> params) throws ServiceHttpException {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/accounts/" + accountID + "/orders");
        if (params != null) {
            for (String paramName : params.keySet()) {
                hb.parameter(paramName, params.get(paramName));
            }
        }
        Response resp = hb.authorization().get().execute();

        if (resp.getCode() == 200) {
            JsonSerializationService<Orders> jsonServ = new JsonSerializationService<>();
            return jsonServ.objectFromJson(resp.getBody(), Orders.class);
        } else throw new ServiceHttpException(resp.getCode(), resp.getBody());
    }

    /**
     * <a href="http://developer.oanda.com/rest-live/orders/#createNewOrder">
     * Create new order
     * </a>
     *
     * @param accountID  id of iser's account
     * @param instrument Instrument to open the order on
     * @param units      The number of units to open order for
     * @param side       Direction of the order, either 'buy' or 'sell'
     * @param type       The type of the order 'limit', 'stop', 'marketIfTouched' or 'market'
     * @param params:    additional parameters or null:
     *                   expiry: Required If order type is 'limit', 'stop', or 'marketIfTouched'. The order expiration time in UTC. The value specified must be in a valid datetime format.
     *                   price: Required If order type is 'limit', 'stop', or 'marketIfTouched'. The price where the order is set to trigger at.
     *                   lowerBound: Optional The minimum execution price.
     *                   upperBound: Optional The maximum execution price.
     *                   stopLoss: Optional The stop loss price.
     *                   takeProfit: Optional The take profit price.
     *                   trailingStop: Optional The trailing stop distance in pips, up to one decimal place.
     * @return fx.domain.NewOrder
     * @throws ServiceHttpException
     */
    public NewOrder create(int accountID,
                           String instrument,
                           int units,
                           String side,
                           String type,
                           Map<String, String> params) throws ServiceHttpException {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/accounts/" + accountID + "/orders");
        hb.parameter("instrument", instrument);
        hb.parameter("units", String.valueOf(units));
        hb.parameter("side", side);
        hb.parameter("type", type);

        if (params != null) {
            for (String paramName : params.keySet()) { // adding of additional parameters
                hb.parameter(paramName, params.get(paramName));
            }
        }
        Response resp = hb.authorization().post().execute();
        if (resp.getCode() == 200) {
            JsonSerializationService<NewOrder> jsonServ = new JsonSerializationService<>();
            return jsonServ.objectFromJson(resp.getBody(), NewOrder.class);
        } else throw new ServiceHttpException(resp.getCode(), resp.getBody());
    }

    /**
     * <a href="http://developer.oanda.com/rest-live/orders/#getInformationForAnOrder">
     * Get information for an order
     * </a>
     * @param accountID id of an user's account
     * @param orderID id of an order in user's account
     * @return fx.domain.Order
     * @throws ServiceHttpException
     */
    public Order getInformation(int accountID, int orderID) throws ServiceHttpException {
        HttpBuilder hb = new HttpBuilder("https://api-fxpractice.oanda.com/v1/accounts/" + accountID + "/orders/" + orderID);
        Response resp = hb.authorization().get().execute();
        if (resp.getCode() == 200) {
            JsonSerializationService<Order> jsonServ = new JsonSerializationService<>();
            return jsonServ.objectFromJson(resp.getBody(), Order.class);
        } else throw new ServiceHttpException(resp.getCode(), resp.getBody());
    }
}
