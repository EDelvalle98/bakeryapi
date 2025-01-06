package com.sistersbakery.bakeryshop.service;

import com.sistersbakery.bakeryshop.exception.ResourceNotFoundException;
import com.sistersbakery.bakeryshop.model.Customer;
import com.sistersbakery.bakeryshop.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        logger.info("Fetching all customers");
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            customers.add(customer);
        }
        return customers;
    }

    public Customer getCustomerById(Long id) {
        logger.info("Fetching customer with id: {}", id);
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer saveCustomer(Customer customer) {
        logger.info("Saving customer: {}", customer);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
        logger.info("Deleting customer with id: {}", id);
        customerRepository.deleteById(id);
    }

    public List<Customer> searchCustomers(String keyword) {
        logger.info("Searching customers with keyword: {}", keyword);
        return customerRepository.findByNameContaining(keyword);
    }
}
