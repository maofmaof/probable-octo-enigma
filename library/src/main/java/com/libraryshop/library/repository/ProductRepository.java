package com.libraryshop.library.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryshop.library.model.Product;

public interface ProductRepository extends JpaRepository <Product, Integer> {
    
}
