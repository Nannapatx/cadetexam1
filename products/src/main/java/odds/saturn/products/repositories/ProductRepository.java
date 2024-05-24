package odds.saturn.products.repositories;

import odds.saturn.products.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    Products findByName(String name);
    List<Products> findByGrind_optionAndRoast_level (String grind_option, Integer roast_level);
}
