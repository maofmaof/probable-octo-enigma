package com.libraryshop.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryshop.library.model.Customer;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    
}
