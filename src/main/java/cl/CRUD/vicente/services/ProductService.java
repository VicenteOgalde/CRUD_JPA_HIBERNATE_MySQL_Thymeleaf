package cl.CRUD.vicente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.CRUD.vicente.entities.Product;
import cl.CRUD.vicente.repository.IProductRepository;

@Service
public class ProductService {

	@Autowired
	private IProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
	public List<Product> filterAll(String keyWord){
		return productRepository.filterAll(keyWord);
	}
}
