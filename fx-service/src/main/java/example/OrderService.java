package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    @Autowired
    IOrderDb repository;

    @Override
    public String createOrder(Order order) {
        return repository.createOrder(order);
    }

    @Override
    public Order getOrder(String id) {
        return repository.getOrder(id);
    }

    @Override
    public void updateOrder(Order order) {
        repository.updateOrder(order);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

}
