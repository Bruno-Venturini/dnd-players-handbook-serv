package com.handbook.handbookapi.inventory.item;

import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "weapon_properties")
@SequenceGenerator(name = "seq_weapon_properties", sequenceName = "seq_weapon_properties")
public class WeaponProperties implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_weapon_properties")
    @Column(name = "id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    public WeaponProperties() {
    }

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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
