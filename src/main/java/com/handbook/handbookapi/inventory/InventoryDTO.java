package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.inventory.item.ItemDTO;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryDTO {

    private Long id;
    private List<ItemDTO> items;
    private Double capacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public InventoryDTO() {
    }

    public static InventoryDTO fromEntity(Inventory inventory) {
        InventoryDTO dto = new InventoryDTO();
        dto.setId(inventory.getId());
        dto.setCapacity(inventory.getCapacity());
        dto.setItems(ItemDTO.fromEntity(inventory.getItems()));
        return dto;
    }

    public Inventory toEntity() {
        Inventory inventory = new Inventory();
        inventory.setCapacity(this.getCapacity());
        inventory.setItems(this.toEntity().getItems());
        return inventory;
    }

    public static List<InventoryDTO> fromEntity(List<Inventory> inventory) {
        return inventory.stream().map(InventoryDTO::fromEntity).collect(Collectors.toList());
    }

}
