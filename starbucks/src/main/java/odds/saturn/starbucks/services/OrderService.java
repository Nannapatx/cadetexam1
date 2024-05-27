package odds.saturn.starbucks.services;

import odds.saturn.starbucks.DTOs.OrderDTO;
import odds.saturn.starbucks.entities.*;
import odds.saturn.starbucks.repositories.OrderItemRepository;
import odds.saturn.starbucks.repositories.OrderRepository;
import odds.saturn.starbucks.repositories.ProductRepository;
import odds.saturn.starbucks.repositories.UserRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Orders> getAllOrder() { return orderRepository.findAll(); }


    public Orders getOrderById(String orderId) {
        return orderRepository.findById(orderId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    public List<Orders> getUserOrder(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    public OrderItems addToCart(Integer userId, OrderItems newOrderItem) {
        Products selectedProduct = productRepository.findById(newOrderItem.getProductId()).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        newOrderItem.setUserId(userId);
        newOrderItem.setUser(userRepository.findById(userId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
        newOrderItem.setProduct(selectedProduct);
        newOrderItem.setPrice(selectedProduct.getPrice() * newOrderItem.getQuantity());
        return orderItemRepository.saveAndFlush(newOrderItem);
    }

    public Orders createOrder(Integer userId) {
        double totalPrice = 0.0;
        List<OrderItems> orderItems = orderItemRepository.findAllByUserId(userId);
        for (OrderItems orderItem : orderItems) {
            totalPrice += orderItem.getPrice();
        }
        Orders newOrder = new Orders();
        newOrder.setUserId(userId);
        newOrder.setUser(userRepository.findById(userId).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")));
        newOrder.setOrderItems(orderItems);
        newOrder.setTotalPrice(totalPrice);
        newOrder.setStatus(OrderStatusEnum.PENDING.getStatus());
        newOrder.setOrderDate(ZonedDateTime.now());
        return orderRepository.saveAndFlush(newOrder);
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
