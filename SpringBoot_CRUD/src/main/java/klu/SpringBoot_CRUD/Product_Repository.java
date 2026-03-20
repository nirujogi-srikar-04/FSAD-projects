package klu.SpringBoot_CRUD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface Product_Repository extends JpaRepository<Product, Long>{
	@Modifying
	@Transactional
	
	@Query("UPDATE Product p SET p.price = :price WHERE p.name = :name")
	int updatePriceByName(@Param("price") Double price, @Param("name") String name);


//for countby
	long countById(Long id);
}