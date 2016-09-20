package example;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class OrderDb implements IOrderDb {

    private Map<String, Order> inMemDb = new HashMap<>();

    @Override
    public String createOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        inMemDb.put(order.getId(), order);
        return order.getId();
    }

    @Override
    public Order getOrder(String id) {
        return inMemDb.get(id);
    }

    @Override
    public void updateOrder(Order order) {
        inMemDb.put(order.getId(), order);
    }

    @Override
    public void delete(String id) {
        inMemDb.remove(id);
    }
}
