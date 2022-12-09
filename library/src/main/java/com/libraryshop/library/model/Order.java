package com.libraryshop.library.model; 
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order{

    public Order() {

    }
    public Order(String orderDate) {
        this.orderDate = orderDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private int orderId;

    private String orderDate;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    public Set<OrderDetails> orderDetails;

    public void setOrderDetails(Set<OrderDetails>orderDetails) {
        this.orderDetails = orderDetails;
    }

}
