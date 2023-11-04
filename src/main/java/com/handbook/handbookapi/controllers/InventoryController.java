package com.handbook.handbookapi.controllers;

import com.handbook.handbookapi.model.Inventory;
import com.handbook.handbookapi.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/add")
    public ResponseEntity<Inventory> add(Inventory inventory) {
        Inventory savedInventory = inventoryService.save(inventory);

        return ResponseEntity.created(URI.create("/api/inventory/" + savedInventory.getId())).body(savedInventory);
    }
}
