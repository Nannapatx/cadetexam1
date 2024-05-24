package odds.saturn.products.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "description")
    private String description;

    @Column(name = "region")
    private String region;

    @Column(name = "weight")
    private Integer weight;

    @Column(name = "flavor_profile")
    private String flavor_profile;

    public List<String> getFlavorProfile() {
        return Arrays.asList(this.flavor_profile.split(","));
    }

    public void setFlavorProfile(List<String> flavor_profile) {
        this.flavor_profile = String.join(",", flavor_profile);
    }

    @Column(name = "grind_option")
    private static String grind_option;

    public static List<String> getGrindOption() {
        return Arrays.asList(grind_option.split(","));
    }

    public void setGrindOption(List<String> grind_option) {
        this.grind_option = String.join(",", grind_option);
    }

    public static String getPrimaryGrindOption() {
        return getGrindOption().get(0);
    }

    @Column(name = "roast_level")
    private Integer roast_level;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "stock")
    private Integer stock;
}
