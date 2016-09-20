package fx.domain;

import java.util.List;

/**
 * <a href="http://developer.oanda.com/rest-live/orders/#getOrdersForAnAccount">
 * Orders for an account
 * </a>
 * This will return all pending orders for an account. Note: pending take profit or stop loss orders are recorded in the
 * open trade object, and will not be returned in this request.
 */
public class Orders {
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrder(List<Order> orders) {
        this.orders = orders;
    }
}
