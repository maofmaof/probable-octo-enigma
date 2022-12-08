package com.libraryshop.library;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.libraryshop.library.repository.CustomerRepository;
import com.libraryshop.library.repository.OrderRepository;
import com.libraryshop.library.repository.ProductRepository;
import com.libraryshop.library.model.Order;
import com.libraryshop.library.model.OrderDetails;
import com.libraryshop.library.model.OrderDetailsPK;
import com.libraryshop.library.model.Product;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class Controller {

    OrderRepository orderRepository;
    ProductRepository productRepository;
    CustomerRepository customerRepository;

    @GetMapping("/test/{productId}")
    public List<Order> addOrder(@PathVariable int productId) {

        Order order = new Order("11:30");
        order = orderRepository.save(order);

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setOrderProduct(order, productRepository.findById(productId).get());
       // orderDetails.setOrderProduct(orderRepository.findById(1).get(), productRepository.findById(productId).get());

        orderDetails.setUnitsOnOrder(productRepository.findById(productId).get().getUnitsOnorder());
        orderDetails.setUnitsInStock(productRepository.findById(productId).get().getUnitsInStock());

        order.setOrderDetails(orderDetails);

        orderRepository.save(order);

        return orderRepository.findAll();

    }

}
