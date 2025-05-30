package com.handbook.handbookapi.inventory.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.handbook.handbookapi.common.BaseEntity;
import com.handbook.handbookapi.value.Value;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "weapons")
@PrimaryKeyJoinColumn(name = "item_id")
@SequenceGenerator(name = "seq_weapons", sequenceName = "seq_weapons")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Weapon extends Item implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_weapons")
    @Column(name = "id")
    private Long id;

    @Column(name = "damage", nullable = false)
    private String damage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "weapon", cascade = CascadeType.ALL)
    private List<WeaponProperties> properties;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public Weapon() {
    }

    public Weapon(String name, Integer weight, Value value, String damage, List<WeaponProperties> properties) {
        super(name, weight, value);
        this.damage = damage;
        this.properties = properties;
    }
}
