package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.character.Character;
import com.handbook.handbookapi.common.AbstractService;
import com.handbook.handbookapi.exceptions.GameRuleException;
import com.handbook.handbookapi.exceptions.MaximumWeightException;
import com.handbook.handbookapi.inventory.item.Item;
import com.handbook.handbookapi.inventory.item.ItemDTO;
import com.handbook.handbookapi.inventory.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

@Service
public class InventoryService extends AbstractService<Inventory, Long> {

    private static final String API_DND5E_URL = "https://www.dnd5eapi.co/api/";
    private static final String API_DND5E_EQUIPMENT_URL = API_DND5E_URL + "equipment/";
    public static final String MSG_INVENTORY_NOT_FOUND = "Inventory not found";
    public static final String MSG_ITEM_NOT_FOUND = "Item not found";
    public static final String MSG_ERROR_DELETE_INVENTORY = "Error deleting items from inventory: %s";

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ItemService itemService;

    @Override
    protected JpaRepository<Inventory, Long> getRepository() {
        return inventoryRepository;
    }

    @Override
    public Inventory save(Inventory inventory) {
        if (Objects.nonNull(inventory.getId())) {
            if (itemService.getSumOfAllInventoryItems(inventory.getId()) > inventory.getCapacity()) {
                throw new MaximumWeightException();
            }
        }

        return super.save(inventory);
    }

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    public Inventory findByCharacterId(Long idCharacter) {
        return inventoryRepository.findByCharacterId(idCharacter);
    }

    public Inventory createNewInventory(Character characterSaved) {
        Inventory inventory = new Inventory();

        inventory.setCharacter(characterSaved);
        inventory.setCapacity(0.0);

        return save(inventory);
    }


    public Inventory addItem(Long idInventory, String itemName) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            LinkedHashMap<?, ?> json = restTemplate.getForObject(API_DND5E_EQUIPMENT_URL + itemName, LinkedHashMap.class);

            if (Objects.nonNull(json)) {
                ItemDTO itemDTO = ItemDTO.fromApi(json);

                Inventory inventory = findById(idInventory);

                if (Objects.nonNull(inventory)) {
                    Item item = itemDTO.toEntity();
                    item.setInventory(inventory);

                    itemService.save(item);
                    inventory = inventoryRepository.save(inventory);
                } else {
                    throw new GameRuleException(MSG_INVENTORY_NOT_FOUND);
                }

                return inventory;
            } else {
                throw new GameRuleException(MSG_ITEM_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new GameRuleException(e.getMessage());
        }
    }

    private Inventory findById(Long idInventory) {
        return inventoryRepository.findById(idInventory).orElse(null);
    }

    public Inventory removeAllItems(Long idInventory) {
        try {
            Inventory inventory = findById(idInventory);

            if (Objects.nonNull(inventory)) {
                List<Item> items = inventory.getItems();

                if (Objects.nonNull(items)) {
                    items.forEach(item -> itemService.delete(item));
                }
            }

            return inventory;
        } catch (Exception e) {
            throw new GameRuleException(String.format(MSG_ERROR_DELETE_INVENTORY, e.getMessage()));
        }
    }
}
