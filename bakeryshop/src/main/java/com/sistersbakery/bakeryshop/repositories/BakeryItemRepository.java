package com.sistersbakery.bakeryshop.repositories;

import com.sistersbakery.bakeryshop.model.BakeryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BakeryItemRepository extends CrudRepository<BakeryItem, Long> {
    List<BakeryItem> findByNameContaining(String keyword);
}
