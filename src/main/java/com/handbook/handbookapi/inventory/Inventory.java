package com.handbook.handbookapi.inventory;

import com.handbook.handbookapi.character.Character;
import com.handbook.handbookapi.common.BaseEntity;
import com.handbook.handbookapi.inventory.item.Item;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventories")
@SequenceGenerator(name = "seq_inventories", sequenceName = "seq_inventories", allocationSize = 1)
public class Inventory implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inventories")
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character character;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = true)
    private List<Item> items;

    private Double capacity;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Inventory() {
    }
}
