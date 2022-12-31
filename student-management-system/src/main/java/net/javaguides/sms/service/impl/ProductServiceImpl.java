package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Product;
import net.javaguides.sms.repository.ProductRepository;
import net.javaguides.sms.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private ProductRepository ProductRepository;
	
	public ProductServiceImpl(ProductRepository ProductRepository) {
		super();
		this.ProductRepository = ProductRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return ProductRepository.findAll();
	}

	@Override
	public Product saveProduct(Product Product) {
		return ProductRepository.save(Product);
	}

	@Override
	public Product getProductById(Long id) {
		return ProductRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Product Product) {
		return ProductRepository.save(Product);
	}

	@Override
	public void deleteProductById(Long id) {
		ProductRepository.deleteById(id);	
	}

}
