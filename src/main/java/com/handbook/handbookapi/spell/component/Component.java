package com.handbook.handbookapi.spell.component;

import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "components")
@SequenceGenerator(name = "seq_components", sequenceName = "seq_components")
public class Component implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_components")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "component_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ComponentType componentType;

    public Component() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }
}
