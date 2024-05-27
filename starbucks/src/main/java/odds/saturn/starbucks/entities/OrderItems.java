package odds.saturn.starbucks.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderItems")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private Orders order;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
    private Products product;

    @Column(name = "productId")
    private Integer productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    @Column(name = "userId")
    private Integer userId;

}
