package odds.saturn.starbucks.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum OrderStatusEnum {
    PENDING("PENDING"),
    DELIVERED("DELIVERED"),
    CANCELLED("CANCELLED");

    private String status;
}
