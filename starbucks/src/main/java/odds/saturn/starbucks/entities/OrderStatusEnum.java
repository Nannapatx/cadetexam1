package odds.saturn.starbucks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum OrderStatusEnum {
    PENDING("PENDING"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED");

    private String status;
}
