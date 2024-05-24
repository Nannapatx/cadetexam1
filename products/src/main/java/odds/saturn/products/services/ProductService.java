package odds.saturn.products.services;

import odds.saturn.products.entities.Products;
import odds.saturn.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Products createProduct (Products newProduct) {
        newProduct.setFlavorProfile(newProduct.getFlavorProfile());
        newProduct.setGrindOption(newProduct.getGrindOption());
        return productRepository.saveAndFlush(newProduct);
    }

    public Products updateProduct (Integer id, Products updatedProduct) {
        Products product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setRegion(updatedProduct.getRegion());
        product.setWeight(updatedProduct.getWeight());
        product.setFlavorProfile(updatedProduct.getFlavorProfile());
        product.setGrindOption(updatedProduct.getGrindOption());
        return productRepository.saveAndFlush(product);
    }

    public Products deleteProduct (Integer id) {
        Products product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }
        productRepository.deleteById(id);
        return product;
    }

    public Products findByProductName(String name) {
        return productRepository.findByName(name);
    }

    public List<Products> findByGrindOptionsAndRoastLevel(String grindOptions, Integer roastLevel) {
        return productRepository.findByGrind_optionAndRoast_level(grindOptions, roastLevel);
    }
}
