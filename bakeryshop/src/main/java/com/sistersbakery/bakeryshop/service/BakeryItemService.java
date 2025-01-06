package com.sistersbakery.bakeryshop.service;

import com.sistersbakery.bakeryshop.exception.ResourceNotFoundException;
import com.sistersbakery.bakeryshop.model.BakeryItem;
import com.sistersbakery.bakeryshop.repositories.BakeryItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BakeryItemService {

    private static final Logger logger = LoggerFactory.getLogger(BakeryItemService.class);

    @Autowired
    private BakeryItemRepository bakeryItemRepository;

    public List<BakeryItem> getAllBakeryItems() {
        logger.info("Fetching all bakery items");
        List<BakeryItem> items = new ArrayList<>();
        for (BakeryItem item : bakeryItemRepository.findAll()) {
            items.add(item);
        }
        return items;
    }

    public BakeryItem getBakeryItemById(Long id) {
        logger.info("Fetching bakery item with id: {}", id);
        return bakeryItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public BakeryItem saveBakeryItem(BakeryItem bakeryItem) {
        logger.info("Saving bakery item: {}", bakeryItem);
        return bakeryItemRepository.save(bakeryItem);
    }

    public void deleteBakeryItem(Long id) {
        if (!bakeryItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Bakery item not found with id: " + id);
        }
        logger.info("Deleting item with id: {}", id);
        bakeryItemRepository.deleteById(id);
    }

    public List<BakeryItem> searchBakeryItems(String keyword) {
        logger.info("Searching bakery items with keyword: {}", keyword);
        return bakeryItemRepository.findByNameContaining(keyword);
    }
}

