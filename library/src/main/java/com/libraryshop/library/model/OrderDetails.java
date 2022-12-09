package com.libraryshop.library.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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

    public OrderDetails(OrderDetailsPK id) {
        this.id = id;
    }

    public OrderDetails(OrderDetailsPK id, int unitsInstock, int unitsOnOrder) {
        this.id = id;
        this.unitsInStock = unitsInstock;
        this.unitsOnOrder = unitsOnOrder;
    }

    public void setOrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
        this.id = new OrderDetailsPK(order.getOrderId(), product.getProductId());
    }

    @JsonIgnore
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;

    @JsonIgnore
    @ManyToOne()
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    int unitsInStock;
    int unitsOnOrder;

}
