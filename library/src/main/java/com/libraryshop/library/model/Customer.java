package com.libraryshop.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "customers")
@Entity
@Data
@AllArgsConstructor
public class Customer {

    Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;
    String companyName;
    String contactName;

}
