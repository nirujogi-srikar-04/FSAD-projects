package klu.SpringBoot_CRUD;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_Service  {
    private final Product_Repository pr;
    
    public Product_Service(Product_Repository product_rep) {
    	this.pr=product_rep;
    	
    }
    
    //create
    public Product addproduct(Product product) {
    	return pr.save(product);
    }

 // Read
    public List<Product> getAllProducts() {
        return pr.findAll();
    }
    public Product updateproduct(Long id, Product product) {
        Product existing = pr.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
         //   existing.setQuantity(product.getQuantity());
            
            return pr.save(existing);
        }
        return null;
    }
 // UPDATE
    public Product updateProduct(Long id, Product product) {
        Product existing = pr.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            //existing.setQuantity(product.getQuantity());
            
            return pr.save(existing);
        }
        return null;
    }
  //update by
    public int updateProductPriceByName(String name, Double price) { 
    	return pr.updatePriceByName(price, name); }
       
    
    // DELETE
    public void deleteProduct(Long id) {
        pr.deleteById(id);
    }

  //countby
    public long countProductById(Long id) { 
    	return pr.countById(id); }   

}