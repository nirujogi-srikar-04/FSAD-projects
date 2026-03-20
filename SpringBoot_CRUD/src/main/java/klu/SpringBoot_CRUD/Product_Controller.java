package klu.SpringBoot_CRUD;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class Product_Controller {

    private final Product_Service ps;

    public Product_Controller(Product_Service product_ser) {
        this.ps = product_ser;
    }

    // Use POST for adding a product
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
    	return ps.addproduct(product);

    }

    // Use GET for displaying products
    @GetMapping("/display")
    public List<Product> getProducts() {
        return ps.getAllProducts();
    }
 // UPDATE Product
    @PutMapping("update/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product) {
        return ps.updateProduct(id, product);
    }
    

// UPDATE BY (price by name) 
    @PutMapping("/updatePrice/{name}/{price}") 
    public String updatePrice(@PathVariable String name, @PathVariable Double price) 
    { 
      int updated = ps.updateProductPriceByName(name, price); 
      return updated > 0 ? "Price updated successfully" : "No product found with given name"; 
    }
    
 // COUNT BY id 
    @GetMapping("/countById/{id}") 
    public ResponseEntity<Long> countById(@PathVariable Long id) { 
      long count = ps.countProductById(id); 
      if (count > 0) { 
        return ResponseEntity.ok(count); 
      } 
      else { 
        return ResponseEntity.status(HttpStatus.NOT_FOUND) .body(count); 
      } 
    }
 
  }