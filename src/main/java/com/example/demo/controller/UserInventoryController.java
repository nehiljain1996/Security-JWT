package com.example.demo.controller;

import com.example.demo.dto.InventoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
@Slf4j
public class UserInventoryController {
    @GetMapping
    public List<InventoryDTO> getUserInventory() {
        return Arrays.asList(
                new InventoryDTO("Item1", 10),
                new InventoryDTO("Item2", 5)
        );
    }

    //write a post method
    @PostMapping
    public InventoryDTO addItemToInventory(InventoryDTO inventoryDTO) {
        log.info("Adding item to inventory: " + inventoryDTO.getItemName());
        return inventoryDTO;
    }

    //create a put mapping as well
    @PutMapping
    public InventoryDTO updateInventory(InventoryDTO inventoryDTO) {
        log.info("Updating item in inventory: " + inventoryDTO.getItemName());
        return inventoryDTO;
    }

    //delete mapping

    @DeleteMapping
    public InventoryDTO deleteItemFromInventory(InventoryDTO inventoryDTO) {
        log.info("Deleting item from inventory: " + inventoryDTO.getItemName());
        return inventoryDTO;
    }

}
