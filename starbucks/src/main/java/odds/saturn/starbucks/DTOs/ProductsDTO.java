package odds.saturn.starbucks.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
    private String name;
    private Double price;
    private String[] imageUrls;
    private String category;
}
