package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import example.IOrderService;
import example.Order;

@RestController
@RequestMapping("/order")
@Service
public class ExampleController {

    @Autowired
    IOrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object addOrder(@RequestBody Order order) {
        String id = orderService.createOrder(order);
        return "added new order with id: " + id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order findOrder(@PathVariable String id) {
        return orderService.getOrder(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Object updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return "order updated";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object removeOrder(@PathVariable String id) {
        orderService.delete(id);
        return "order removed";
    }

}
