package com.libraryshop.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryshop.library.model.Order;

public interface OrderRepository extends JpaRepository <Order, Integer> {
    
}
