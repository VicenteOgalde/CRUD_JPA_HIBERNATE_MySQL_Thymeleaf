package cl.CRUD.vicente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.CRUD.vicente.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE"
			+" CONCAT(p.id,p.name,p.brand,p.madeIn,p.price)"
			+" LIKE %?1%")
	public List<Product> filterAll(String keyWord);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
