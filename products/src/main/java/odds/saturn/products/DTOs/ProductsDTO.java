package odds.saturn.products.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import odds.saturn.products.entities.Products;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsDTO {
    private Integer id;
    private String name;
    private Integer roastLevel;
    private Double price;
    private String image;
    private String grindOption = Products.getPrimaryGrindOption();
}
