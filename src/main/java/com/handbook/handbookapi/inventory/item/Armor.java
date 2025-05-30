package com.handbook.handbookapi.inventory.item;


import com.handbook.handbookapi.value.Value;

import javax.persistence.*;

@Entity
@Table(name = "armors")
@PrimaryKeyJoinColumn(name = "item_id")
@SequenceGenerator(name = "seq_armors", sequenceName = "seq_armors", allocationSize = 1)
public class Armor extends Item {

    @Column(name = "strength")
    private Integer strength;

    @Column(name = "stealth")
    private Boolean stealth;

    @Column(name = "armor_class")
    private Integer armorClass;

    @Column(name = "armor_type")
    @Enumerated(EnumType.STRING)
    private ArmorType armorType;

    public Armor() {
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

    public Armor(String name, Integer weight, Value value) {
        super(name, weight, value);
    }

    public Armor(String name, Integer weight, Value value, Integer strength, Boolean stealth, Integer armorClass, ArmorType armorType) {
        super(name, weight, value);
        this.strength = strength;
        this.stealth = stealth;
        this.armorClass = armorClass;
        this.armorType = armorType;
    }
}
