package com.sistersbakery.bakeryshop.controller;

import com.sistersbakery.bakeryshop.exception.ResourceNotFoundException;
import com.sistersbakery.bakeryshop.model.BakeryOrder;
import com.sistersbakery.bakeryshop.service.BakeryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class BakeryOrderController {

    @Autowired
    private BakeryOrderService bakeryOrderService;

    @GetMapping("/all")
    public ResponseEntity<List<BakeryOrder>> getAllOrders() {
        List<BakeryOrder> orders = bakeryOrderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<BakeryOrder> getOrderById(@PathVariable Long id) {
        BakeryOrder order = bakeryOrderService.getOrderById(id);
        if (order == null) {
            throw new ResourceNotFoundException("Order not found with id: " + id);
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping("/add")
    public ResponseEntity<BakeryOrder> addOrder(@RequestBody BakeryOrder order) {
        BakeryOrder createdOrder = bakeryOrderService.saveOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BakeryOrder> updateOrder(@PathVariable Long id, @RequestBody BakeryOrder order) {
        order.setOrderId(id);
        BakeryOrder updatedOrder = bakeryOrderService.saveOrder(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        bakeryOrderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

