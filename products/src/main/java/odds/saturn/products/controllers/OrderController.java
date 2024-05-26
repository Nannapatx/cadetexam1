package odds.saturn.products.controllers;

import odds.saturn.products.DTOs.OrderDTO;
import odds.saturn.products.entities.Orders;
import odds.saturn.products.services.OrderService;
import odds.saturn.products.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{orderId}")
    public Orders getOrderById(String orderId) {
        return orderService.getOrderById(orderId);
    }

    @PatchMapping("/{orderId}")
    public Orders updateOrderStatus(@PathVariable String orderId, @RequestBody OrderDTO status) {
        return orderService.UpdateOrderStatus(orderId, status);
    }

}
