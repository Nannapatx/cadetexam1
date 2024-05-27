package odds.saturn.starbucks.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import odds.saturn.starbucks.entities.OrderItems;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDTO {
    private String status;
    private String orderDate;
    private String totalPrice;
    private List<OrderItems> orderItems;
}
