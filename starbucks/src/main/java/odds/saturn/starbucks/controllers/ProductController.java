package odds.saturn.starbucks.controllers;

import odds.saturn.starbucks.DTOs.PageDTO;
import odds.saturn.starbucks.DTOs.ProductDetailDTO;
import odds.saturn.starbucks.DTOs.ProductsDTO;
import odds.saturn.starbucks.entities.Products;
import odds.saturn.starbucks.services.ProductService;
import odds.saturn.starbucks.utils.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ProductDetailDTO getProductById(@PathVariable Integer id) {
        return modelMapper.map(productService.getProductById(id), ProductDetailDTO.class);
    }

    @GetMapping("/search")
    public List<ProductsDTO> searchProducts(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) String roast,
                                            @RequestParam(required = false) String caffeine,
                                            @RequestParam(required = false) String category) {
        if (name == null && roast == null && category == null && caffeine == null) {
            return listMapper.mapList(productService.getAllProducts(), ProductsDTO.class, modelMapper);
        }
        if ((caffeine != null || category != null || roast != null) && name == null) {
            return listMapper.mapList(
                    productService.filterByCategoryAndRoastAndCaffeine(category, roast, caffeine),
                    ProductsDTO.class, modelMapper);
        }
        return listMapper.mapList(productService.findByProductName(name), ProductsDTO.class, modelMapper);
    }

    @GetMapping("/pages")
    public PageDTO<ProductsDTO> getAllProductsByCategory(@RequestParam(defaultValue = "0") Integer page,
                                                         @RequestParam(defaultValue = "12") Integer size) {
        Page<Products> products = productService.getAllProductsPaginate(page, size);
        return listMapper.toPageDTO(products, ProductsDTO.class, modelMapper);
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
