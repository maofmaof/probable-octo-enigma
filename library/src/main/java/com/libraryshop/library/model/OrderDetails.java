package com.libraryshop.library.model;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Data
public class OrderDetails implements Serializable {

    @EmbeddedId
    OrderDetailsPK id;

    public OrderDetails() {
    }
    public OrderDetails(OrderDetailsPK id, int unitsInstock, int unitsOnOrder) {
        this.unitsInStock = unitsInstock;
        this.unitsOnOrder = unitsOnOrder;
        this.id = id;
    }
    
    @JsonIgnore
    @OneToOne 
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;
    
    @JsonIgnore
    @OneToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    int unitsInStock;
    int unitsOnOrder;

}
