package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
	
	Product saveProduct(Product Product);
	
	Product getProductById(Long id);
	
	Product updateProduct(Product Product);
	
	void deleteProductById(Long id);
}
