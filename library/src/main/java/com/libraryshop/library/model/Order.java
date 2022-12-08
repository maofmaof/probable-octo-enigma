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
    
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    OrderDetails orderDetails; //one to many?

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        this.orderDetails.setOrder(this);
    }

}
