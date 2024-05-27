package odds.saturn.starbucks.controllers;

import odds.saturn.starbucks.DTOs.UserOrderDTO;
import odds.saturn.starbucks.entities.OrderItems;
import odds.saturn.starbucks.entities.Orders;
import odds.saturn.starbucks.entities.Users;
import odds.saturn.starbucks.services.OrderService;
import odds.saturn.starbucks.services.UserService;
import odds.saturn.starbucks.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    ModelMapper modelMapper = new ModelMapper();
    ListMapper listMapper = ListMapper.getInstance();


    @PostMapping("")
    public Users createUser(@RequestBody Users newUser) {
        return userService.createUser(newUser);
    }
    
    @GetMapping("")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
    
    @PostMapping("/{id}/addtocart")
    public OrderItems addToCart(@PathVariable Integer id, @RequestBody OrderItems newOrderItem) {
        return orderService.addToCart(id, newOrderItem);
    }
    
    @PostMapping("/{id}/order")
    public Orders createOrder(@PathVariable Integer id) {
        return orderService.createOrder(id);
    }
    
    @GetMapping("/{id}/orders")
    public List<UserOrderDTO> getUserOrder(@PathVariable Integer id) {
        return listMapper.mapList(orderService.getUserOrder(id), UserOrderDTO.class, modelMapper);
    }

    @PutMapping("/{id}")
    public Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    
}
