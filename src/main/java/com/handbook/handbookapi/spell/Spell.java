package com.handbook.handbookapi.spell;

import com.handbook.handbookapi.common.BaseEntity;
import com.handbook.handbookapi.spell.component.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "spells")
@SequenceGenerator(name = "seq_spells", sequenceName = "seq_spells", allocationSize = 1)
public class Spell implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_spells")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name = "casting_time", nullable = false)
    private Integer castingTime;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "range", nullable = false)
    private Double range;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "necessary_objects")
    private String necessaryObject;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "spell_components",
            joinColumns = @JoinColumn(name = "spell_id"),
            inverseJoinColumns = @JoinColumn(name = "component_id")
    )
    private List<Component> components;

    public Spell() {
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

    public Integer getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(Integer castingTime) {
        this.castingTime = castingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRange() {
        return range;
    }

    public void setRange(Double range) {
        this.range = range;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getNecessaryObject() {
        return necessaryObject;
    }

    public void setNecessaryObject(String necessaryObject) {
        this.necessaryObject = necessaryObject;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
