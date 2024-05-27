package odds.saturn.starbucks.repositories;

import odds.saturn.starbucks.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    @Query("SELECT p FROM Products p WHERE p.name LIKE %:name%")
    List<Products> findByName(String name);

    List<Products> findProductsByCaffeineAndRoastAndCategory(String caffeine, String roast, String category);
    List<Products> findProductsByCaffeineAndRoast(String caffeine, String roast);
    List<Products> findProductsByCaffeineAndCategory(String caffeine, String category);
    List<Products> findProductsByRoastAndCategory(String roast, String category);
    List<Products> findProductsByCaffeine(String caffeine);
    List<Products> findProductsByRoast(String roast);
    List<Products> findProductsByCategory(String category);

}
