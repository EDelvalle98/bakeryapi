package com.sistersbakery.bakeryshop.repositories;

import com.sistersbakery.bakeryshop.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByNameContaining(String keyword);
}
