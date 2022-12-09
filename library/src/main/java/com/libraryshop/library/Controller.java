package com.libraryshop.library;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.libraryshop.library.repository.CustomerRepository;
import com.libraryshop.library.repository.OrderRepository;
import com.libraryshop.library.repository.ProductRepository;
import com.libraryshop.library.model.Order;
import com.libraryshop.library.model.OrderDetails;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Controller {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    CustomerRepository customerRepository;

    @GetMapping("/test/{productId1}/{productId2}")
    public List<Order> addOrder(@PathVariable int productId1, @PathVariable int productId2) {

        Order order = new Order("11:30");
        order = orderRepository.save(order);

        OrderDetails orderDetails1 = new OrderDetails();
        OrderDetails orderDetails2 = new OrderDetails();
        
        orderDetails1.setOrderProduct(order, productRepository.findById(productId1).get());
        orderDetails1.setUnitsOnOrder(productRepository.findById(productId1).get().getUnitsOnorder());
        orderDetails1.setUnitsInStock(productRepository.findById(productId1).get().getUnitsInStock());

        orderDetails2.setOrderProduct(order, productRepository.findById(productId2).get());
        orderDetails2.setUnitsOnOrder(productRepository.findById(productId2).get().getUnitsOnorder());
        orderDetails2.setUnitsInStock(productRepository.findById(productId2).get().getUnitsInStock());

        Set<OrderDetails> apa = new LinkedHashSet<OrderDetails>();

        apa.add(orderDetails1);
        apa.add(orderDetails2);

        order.setOrderDetails(apa);

        orderRepository.save(order);

        return orderRepository.findAll();

    }

}
