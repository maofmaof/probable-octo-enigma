package com.libraryshop.library;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.libraryshop.library.model.Product;
import com.libraryshop.library.repository.CustomerRepository;
import com.libraryshop.library.repository.OrderRepository;
import com.libraryshop.library.repository.ProductRepository;

import lombok.AllArgsConstructor;



@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {

    CustomerRepository customerRepository;
    OrderRepository orderRepository;
    ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {

  /*   customerRepository.save(new Customer(1, "Ikea", "Gustav"));
    customerRepository.save(new Customer(2, "Bauhaus", "Lisa"));        
    customerRepository.save(new Customer(3, "Konsum", "Pelle"));        
    customerRepository.save(new Customer(4, "Gamestop", "Johan"));   
    */

    productRepository.save(new Product("TV1", 100, 250, 10));
    productRepository.save(new Product("TV2", 100, 220, 10));
    productRepository.save(new Product("TV3", 100, 230, 10));
    productRepository.save(new Product("TV4", 100, 240, 10));
    productRepository.save(new Product("TV5", 100, 270, 10));
    productRepository.save(new Product("TV6", 100, 20, 10));
    productRepository.save(new Product("TV1", 100, 20, 10));
    productRepository.save(new Product("TV2", 100, 20, 10));
    productRepository.save(new Product("TV3", 100, 20, 10));
    productRepository.save(new Product("TV4", 100, 20, 10));
    productRepository.save(new Product("TV5", 100, 20, 10));
    productRepository.save(new Product("TV6", 100, 20, 10));

    }




    
}
