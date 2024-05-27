package odds.saturn.starbucks.repositories;

import odds.saturn.starbucks.entities.OrderItems;
import odds.saturn.starbucks.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {
    List<OrderItems> findAllByUserId(Integer userId);
}
