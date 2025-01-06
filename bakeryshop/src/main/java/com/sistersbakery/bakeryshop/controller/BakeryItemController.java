package com.sistersbakery.bakeryshop.controller;

import com.sistersbakery.bakeryshop.exception.ResourceNotFoundException;
import com.sistersbakery.bakeryshop.model.BakeryItem;
import com.sistersbakery.bakeryshop.service.BakeryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bakery-items")
public class BakeryItemController {

    @Autowired
    private BakeryItemService bakeryItemService;

    @GetMapping("/all")
    public ResponseEntity<List<BakeryItem>> getAllItems() {
        List<BakeryItem> items = bakeryItemService.getAllBakeryItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<BakeryItem> getItemById(@PathVariable Long id) {
        BakeryItem item = bakeryItemService.getBakeryItemById(id);
        if (item == null) {
            throw new ResourceNotFoundException("Bakery item not found with id: " + id);
        }
        return ResponseEntity.ok(item);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BakeryItem>> searchItems(@RequestParam String keyword) {
        List<BakeryItem> items = bakeryItemService.searchBakeryItems(keyword);
        List<BakeryItem> result = new ArrayList<BakeryItem>();
        for (BakeryItem item : items) {
            result.add(item);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<BakeryItem> addItem(@RequestBody BakeryItem bakeryItem) {
        BakeryItem createdItem = bakeryItemService.saveBakeryItem(bakeryItem);
        return ResponseEntity.ok(createdItem);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BakeryItem> updateItem(@PathVariable Long id, @RequestBody BakeryItem bakeryItem) {
        bakeryItem.setId(id);
        BakeryItem updatedItem = bakeryItemService.saveBakeryItem(bakeryItem);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        bakeryItemService.deleteBakeryItem(id);
        return ResponseEntity.noContent().build();
    }
}
