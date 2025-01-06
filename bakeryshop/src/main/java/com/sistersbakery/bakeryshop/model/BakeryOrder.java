package com.sistersbakery.bakeryshop.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
    public class BakeryOrder {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long orderId;
        private Long itemId;
        private int quantity;
        private LocalDate orderDate;

        public BakeryOrder(Long orderId, Long itemId, int quantity, LocalDate orderDate) {
            this.orderId = orderId;
            this.itemId = itemId;
            this.quantity = quantity;
            this.orderDate = orderDate;
        }

        public BakeryOrder() {}

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public Long getItemId() {
            return itemId;
        }

        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public LocalDate getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
        }
}
