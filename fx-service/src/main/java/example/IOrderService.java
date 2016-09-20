package example;

public interface IOrderService {
    /**
     * Create new order.
     *
     * @param order order.
     * @return id.
     */
    String createOrder(Order order);

    /**
     * Gets by id.
     *
     * @param id id.
     * @return order.
     */
    Order getOrder(String id);

    /**
     * Updates order by id.
     *
     * @param order order.
     */
    void updateOrder(Order order);

    /**
     * Removes order bu id.
     *
     * @param id id.
     */
    void delete(String id);

}
