package com.handbook.handbookapi.inventory.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.handbook.handbookapi.value.CurrencyType;
import com.handbook.handbookapi.value.Value;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ItemDTO {

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Value value;
    private Long id;
    private String name;
    private Integer weight;
    private String type;
    private Integer strength;
    private Boolean stealth;
    private Integer armorClass;
    private ArmorType armorType;
    private String damage;
    private List<WeaponProperties> properties;

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Boolean getStealth() {
        return stealth;
    }

    public void setStealth(Boolean stealth) {
        this.stealth = stealth;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public List<WeaponProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<WeaponProperties> properties) {
        this.properties = properties;
    }

    public Item toEntity() {
        return switch (type) {
            case "WEAPON" ->
                    new Weapon(this.getName(), this.getWeight(), this.getValue(), this.getDamage(), this.getProperties());
            case "ARMOR" -> new Armor(this.getName(), this.getWeight(), this.getValue(), this.getStrength(),
                    this.getStealth(), this.getArmorClass(), this.getArmorType());
            default -> new Item(this.getName(), this.getWeight(), this.getValue());
        };
    }

    public static ItemDTO fromEntity(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setWeight(item.getWeight());
        itemDTO.setType("ITEM");
        itemDTO.setValue(item.getValue());

        if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            itemDTO.setDamage(weapon.getDamage());
            itemDTO.setProperties(weapon.getProperties());
            itemDTO.setType("WEAPON");
        }

        if (item instanceof Armor) {
            Armor armor = (Armor) item;
            itemDTO.setStrength(armor.getStrength());
            itemDTO.setStealth(armor.getStealth());
            itemDTO.setArmorClass(armor.getArmorClass());
            itemDTO.setArmorType(armor.getArmorType());
            itemDTO.setType("ARMOR");
        }

        return itemDTO;
    }

    /**
     * Converts a LinkedHashMap representation of an item from the D&D 5e API into an ItemDTO.
     *
     * @param json The LinkedHashMap containing item data from the API.
     * @return An ItemDTO populated with the data from the LinkedHashMap.
     */
    public static ItemDTO fromApi(LinkedHashMap<?, ?> json) {
        ItemDTO itemDTO = new ItemDTO();
        Value itemValue = new Value();

        itemDTO.setName((String) json.get("name"));
        itemDTO.setWeight((Integer) json.get("weight"));

        LinkedHashMap<?, ?> value = (LinkedHashMap<?, ?>) json.get("cost");
        itemValue.setAmount((Integer) value.get("quantity"));
        itemValue.setCurrencyType(CurrencyType.fromAbbreviation((String) value.get("unit")));
        itemDTO.setValue(itemValue);
        itemDTO.setType("ITEM");

        if (json.get("strength") != null) {
            itemDTO.setStrength((Integer) json.get("strength"));
            itemDTO.setStealth((Boolean) json.get("stealth_disadvantage"));
            itemDTO.setArmorClass((Integer) json.get("armor_class"));
            itemDTO.setArmorType(ArmorType.valueOf((String) json.get("armor_category")));
            itemDTO.setType("ARMOR");
        }

        if (json.get("damage") != null) {
            itemDTO.setDamage((String) ((LinkedHashMap<?, ?>) json.get("damage")).get("damage_dice"));
            itemDTO.setProperties(
                    ((ArrayList<LinkedHashMap<?, ?>>) json.get("properties"))
                            .stream()
                            .map(property -> {
                                WeaponProperties weaponProperties = new WeaponProperties();
                                weaponProperties.setName((String) property.get("name"));
                                return weaponProperties;
                            })
                            .toList());
            itemDTO.setType("WEAPON");
        }

        return itemDTO;
    }

    public static List<ItemDTO> fromEntity(List<Item> items) {
        return items.stream().map(ItemDTO::fromEntity).toList();
    }

    public static Page<ItemDTO> fromEntity(Page<Item> items) {
        return items.map(ItemDTO::fromEntity);
    }
}
