package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.repository.ProductRepository;

@SpringBootApplication
public class ProductManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementSystemApplication.class, args);
	}

	@Autowired
	private ProductRepository ProductRepository;
	
	
	public void run(String... args) throws Exception {
		
		
		
	}

}