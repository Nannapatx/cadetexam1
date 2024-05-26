package odds.saturn.products.services;

import odds.saturn.products.DTOs.OrderDTO;
import odds.saturn.products.entities.Orders;
import odds.saturn.products.entities.Products;
import odds.saturn.products.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getAllOrder() { return orderRepository.findAll(); }

    public Orders getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    public Orders UpdateOrderStatus(String orderId, OrderDTO orderStatus) {
        Orders order = orderRepository.findById(orderId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        if (order == null) {
            return null;
        }
        order.setStatus(orderStatus.getStatus());
        return orderRepository.saveAndFlush(order);
    }
}
