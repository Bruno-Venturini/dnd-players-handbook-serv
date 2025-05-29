package com.handbook.handbookapi.inventory.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.handbook.handbookapi.common.BaseEntity;
import com.handbook.handbookapi.inventory.Inventory;
import com.handbook.handbookapi.value.Value;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seq_items", sequenceName = "seq_items", allocationSize = 1)
public class Item implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_items")
    @Column(name = "item_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "value_id")
    private Value value;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Item() {
    }

    public Item(String name, Integer weight, Value value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
}
