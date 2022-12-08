package com.libraryshop.library;

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

    @GetMapping("/test/{productId}/{orderId}")
    public void addOrder(@PathVariable int productId, @PathVariable int orderId) {

        productRepository.save(new Product("TV", 100, 20, 10));
        productRepository.save(new Product("CD", 100, 20, 10));
        productRepository.save(new Product("COMPUTER", 100, 20, 10));
        productRepository.save(new Product("THING", 100, 20, 10));

        orderRepository.save(new Order("hello1"));

        OrderDetailsPK orderDetailsPK = new OrderDetailsPK();

        orderDetailsPK.setOrderId(orderId);
        orderDetailsPK.setProductId(productId);

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setId(orderDetailsPK);

        orderDetails.setProduct(productRepository.findById(productId).get());
        orderDetails.setOrder(orderRepository.findById(orderId).get());

        orderRepository.save(new Order(1, "09:00", orderDetails));

    }

}
