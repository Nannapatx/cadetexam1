package odds.saturn.starbucks.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String region;
    private Integer weight;
    private String[] flavorProfiles;
    private Integer roastLevel;
    private String[] imageUrls;
    private Integer stock;
    private String grindOption;
}
