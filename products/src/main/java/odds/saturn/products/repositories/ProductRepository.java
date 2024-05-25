package odds.saturn.products.repositories;

import odds.saturn.products.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findByName(String name);

    @Query("SELECT p FROM Products p WHERE p.grindOption = :grindOption AND p.flavorProfile LIKE %:flavorProfile%")
    List<Products> findByGrindOptionAndFlavorProfile(String grindOption, String flavorProfile);

    List<Products> findByGrindOption(String grindOption);

    @Query("SELECT p FROM Products p WHERE p.flavorProfile LIKE %:flavorProfile%")
    List<Products> findByFlavorProfile(String flavorProfile);
}
