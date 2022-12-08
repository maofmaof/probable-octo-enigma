package com.libraryshop.library.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Table(name = "products")
public class Product {

  public Product() {
  }

  public Product(String productName, double unitPrice, int unitsInStock, int unitsOnOrder) {
    this.productName = productName;
    this.unitPrice = unitPrice;
    this.unitsInStock = unitsInStock;
    this.unitsOnorder = unitsOnOrder;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name= "PRODUCT_ID")
  private int productId;
  
  @OneToOne(mappedBy ="product", cascade = {CascadeType.ALL})
  OrderDetails orderDetails;
  
  private String productName;
  private double unitPrice;
  private int unitsInStock;
  private int unitsOnorder;
  //<Set> OneToMany  EN produkt har många ordrar 

}
