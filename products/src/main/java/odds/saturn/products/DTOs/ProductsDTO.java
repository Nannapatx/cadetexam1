package odds.saturn.products.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String[] imageUrls;
    private String grindOption;
    private String[] flavorProfiles;
}