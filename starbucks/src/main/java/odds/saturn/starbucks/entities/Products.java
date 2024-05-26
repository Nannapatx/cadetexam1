package odds.saturn.starbucks.entities;

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

    @Column(name = "flavorProfile")
    private String flavorProfile;

    @Column(name = "roastLevel")
    private Integer roastLevel;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "grindOption")
    private String grindOption;

    public List<String> getFlavorProfiles() {
        return Arrays.asList(this.flavorProfile.split(", "));
    }

    public void setFlavorProfiles(List<String> flavor_profile) {
        this.flavorProfile = String.join(",", flavor_profile);
    }

    public List<String> getImageUrls() {
        return Arrays.asList(this.imageUrl.split(", "));
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrl = String.join(",", imageUrls);
    }
}
