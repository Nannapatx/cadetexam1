package odds.saturn.starbucks.repositories;

import odds.saturn.starbucks.entities.Orders;
import odds.saturn.starbucks.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, String> {
    List<Orders> findByUserId(Integer userId);
}
