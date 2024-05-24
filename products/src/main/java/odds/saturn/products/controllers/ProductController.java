package odds.saturn.products.controllers;

import odds.saturn.products.DTOs.ProductsDTO;
import odds.saturn.products.entities.Products;
import odds.saturn.products.services.ProductService;
import odds.saturn.products.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    ModelMapper modelMapper = new ModelMapper();
    ListMapper listMapper = ListMapper.getInstance();

    @GetMapping("")
    public List<ProductsDTO> getAllProducts() {
        return listMapper.mapList(productService.getAllProducts(), ProductsDTO.class, modelMapper);
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("")
    public Products createProduct(@RequestBody Products newProduct) {
        return productService.createProduct(newProduct);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable Integer id, @RequestBody Products updatedProduct) {
        return productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public Products deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

}
