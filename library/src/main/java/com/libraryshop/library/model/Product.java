package com.libraryshop.library.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
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
  @Column(name = "PRODUCT_ID")
  private int productId;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
  private Set<OrderDetails> orderDetails;

  private String productName;
  private double unitPrice;
  private int unitsInStock;
  private int unitsOnorder;

}
