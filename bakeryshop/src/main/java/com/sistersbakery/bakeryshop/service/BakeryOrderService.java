package com.sistersbakery.bakeryshop.service;

import com.sistersbakery.bakeryshop.exception.ResourceNotFoundException;
import com.sistersbakery.bakeryshop.model.BakeryOrder;
import com.sistersbakery.bakeryshop.repositories.BakeryOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BakeryOrderService {

    private static final Logger logger = LoggerFactory.getLogger(BakeryOrderService.class);

    @Autowired
    private BakeryOrderRepository bakeryOrderRepository;

    public List<BakeryOrder> getAllOrders() {
        logger.info("Fetching all orders");
        List<BakeryOrder> orders = new ArrayList<>();
        for (BakeryOrder order : bakeryOrderRepository.findAll()) {
            orders.add(order);
        }
        return orders;
    }

    public BakeryOrder getOrderById(Long id) {
        logger.info("Fetching order with id: {}", id);
        return bakeryOrderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public BakeryOrder saveOrder(BakeryOrder order) {
        logger.info("Saving order: {}", order);
        return bakeryOrderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        if (!bakeryOrderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bakery order not found with id: " + id);
        }
        logger.info("Deleting order with id: {}", id);
        bakeryOrderRepository.deleteById(id);
    }
}
