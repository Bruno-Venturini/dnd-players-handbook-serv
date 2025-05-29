package com.handbook.handbookapi.character.characterclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.handbook.handbookapi.common.BaseEntity;
import com.handbook.handbookapi.common.Die;
import com.handbook.handbookapi.exceptions.GameRuleException;

import javax.persistence.*;

@Entity
public class CharacterClass implements ICharacterClass, BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "class_type")
    @Enumerated(EnumType.STRING)
    private ClassType classType;

    public CharacterClass() {
    }

    public CharacterClass(Long id, ClassType classType) {
        this.id = id;
        this.classType = classType;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    @Override
    public void performLevelUp() {
        throw new GameRuleException("There is no level up behavior for this game class.");
    }

    @Override
    public void performLongRest() {
        throw new GameRuleException("There is no long rest behavior for this game class.");
    }

    @Override
    public void performShortRest() {
        throw new GameRuleException("There is no short rest behavior for this game class.");
    }

    @JsonIgnore
    public Die getHitDie() {
        throw new GameRuleException("There is no hit die behavior for this game class.");
    }
}
