package odds.saturn.products.services;

import jakarta.el.MethodNotFoundException;
import odds.saturn.products.entities.OrderStatusEnum;
import odds.saturn.products.entities.Orders;
import odds.saturn.products.entities.Products;
import odds.saturn.products.repositories.OrderRepository;
import odds.saturn.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Integer id) {
        return productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    public Page<Products> getAllProductsPaginate(Integer page, Integer size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Products createProduct (Products newProduct) {
        newProduct.setFlavorProfiles(newProduct.getFlavorProfiles());
        newProduct.setImageUrls(newProduct.getImageUrls());
        return productRepository.saveAndFlush(newProduct);
    }

    public Products updateProduct (Integer id, Products updatedProduct) {
        Products product = productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        if (product == null) {
            return null;
        }
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setRegion(updatedProduct.getRegion());
        product.setWeight(updatedProduct.getWeight());
        product.setFlavorProfiles(updatedProduct.getFlavorProfiles());
        product.setRoastLevel(updatedProduct.getRoastLevel());
        product.setImageUrls(updatedProduct.getImageUrls());
        product.setStock(updatedProduct.getStock());
        product.setGrindOption(updatedProduct.getGrindOption());
        return productRepository.saveAndFlush(product);
    }

    public Products deleteProduct (Integer id) {
        Products product = productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        if (product == null) {
            return null;
        }
        productRepository.deleteById(id);
        return product;
    }

    public List<Products> findByProductName(String name) {
        return productRepository.findByName(name);
    }

    public String order(Integer id, Integer quantity) {
        Products product = productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        if (product == null) {
            return null;
        }
        if (product.getStock() > 0 && product.getStock() < quantity) {
            return "Not enough stock! \nStock available: " + product.getStock() + " units.";
        }
        if (product.getStock() == 0) {
            return "Out of stock!";
        } else {
            product.setStock(product.getStock() - quantity);
            productRepository.saveAndFlush(product);
            Orders order = new Orders();
            order.setOrderDate(ZonedDateTime.now());
            order.setStatus(OrderStatusEnum.PENDING.getStatus());
            order.setProductId(product);
            order.setQuantity(quantity);
            order.setTotalPrice(product.getPrice() * quantity);
            orderRepository.saveAndFlush(order);
            return "Order placed!" + "\nOrder detail " + "\norder ID: " + order.getOrderId()
                    + "\nproduct ID: " + order.getProductId().getId() + "\nquantity: " + order.getQuantity()
                    + "\ntotal price: " + order.getTotalPrice() + "\norder date: " + order.getOrderDate()
                    + "\nstatus: " + order.getStatus();
        }
    }

    public List<Products> filterByGrindOptionAndFlavorProfile(String grindOption, String flavorProfile) {
        if(grindOption != null && flavorProfile != null) {
            return productRepository.findByGrindOptionAndFlavorProfile(grindOption, flavorProfile);
        }
        if (grindOption != null) {
            return productRepository.findByGrindOption(grindOption);
        }
        if (flavorProfile != null) {
            return productRepository.findByFlavorProfile(flavorProfile);
        }
        return null;
    }
}
