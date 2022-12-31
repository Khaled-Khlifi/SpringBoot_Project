package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Product;
import net.javaguides.sms.service.ProductService;

@Controller
public class ProductController {
	
	private ProductService ProductService;

	public ProductController(ProductService ProductService) {
		super();
		this.ProductService = ProductService;
	}
	
	// handler method to handle list Products and return mode and view
	@GetMapping("/Products")
	public String listProducts(Model model) {
		model.addAttribute("Products", ProductService.getAllProducts());
		return "Products";
	}
	
	@GetMapping("/Products/new")
	public String createProductForm(Model model) {
		
		// create Product object to hold Product form data
		Product Product = new Product();
		model.addAttribute("Product", Product);
		return "create_Product";
		
	}
	
	@PostMapping("/Products")
	public String saveProduct(@ModelAttribute("Product") Product Product) {
		ProductService.saveProduct(Product);
		return "redirect:/Products";
	}
	
	@GetMapping("/Products/edit/{id}")
	public String editProductForm(@PathVariable Long id, Model model) {
		model.addAttribute("Product", ProductService.getProductById(id));
		return "edit_Product";
	}

	@PostMapping("/Products/{id}")
	public String updateProduct(@PathVariable Long id,
			@ModelAttribute("Product") Product Product,
			Model model) {
		
		
		Product existingProduct = ProductService.getProductById(id);
		existingProduct.setId(id);
		existingProduct.setFirstName(Product.getFirstName());
		existingProduct.setLastName(Product.getLastName());
		existingProduct.setEmail(Product.getEmail());
		
		// save updated Product object
		ProductService.updateProduct(existingProduct);
		return "redirect:/Products";		
	}
	
	// handler method to handle delete Product request
	
	@GetMapping("/Products/{id}")
	public String deleteProduct(@PathVariable Long id) {
		ProductService.deleteProductById(id);
		return "redirect:/Products";
	}
	
}
