package com.handbook.handbookapi.skill;

import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "skills")
@SequenceGenerator(name = "seq_skills", sequenceName = "seq_skills")
public class Skill implements BaseEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "acrobatics", nullable = false)
    private Integer acrobatics;

    @Column(name = "animal_handling", nullable = false)
    private Integer animalhandling;

    @Column(name = "arcana", nullable = false)
    private Integer arcana;

    @Column(name = "athletics", nullable = false)
    private Integer athletics;

    @Column(name = "performance", nullable = false)
    private Integer performance;

    @Column(name = "stealth", nullable = false)
    private Integer stealth;

    @Column(name = "history", nullable = false)
    private Integer history;

    @Column(name = "intimidation", nullable = false)
    private Integer intimidation;

    @Column(name = "medicine", nullable = false)
    private Integer medicine;

    @Column(name = "nature", nullable = false)
    private Integer nature;

    @Column(name = "perception", nullable = false)
    private Integer perception;

    @Column(name = "persuasion", nullable = false)
    private Integer persuasion;

    @Column(name = "sleight_of_hand", nullable = false)
    private Integer sleightofhand;

    @Column(name = "investigation", nullable = false)
    private Integer investigation;

    @Column(name = "religion", nullable = false)
    private Integer religion;

    @Column(name = "insight", nullable = false)
    private Integer insight;

    @Column(name = "survival", nullable = false)
    private Integer survival;

    @Column(name = "deception", nullable = false)
    private Integer deception;

    public Skill() {
    }

    public Skill(Integer startValue) {
        this.acrobatics = startValue;
        this.animalhandling = startValue;
        this.arcana = startValue;
        this.athletics = startValue;
        this.performance = startValue;
        this.stealth = startValue;
        this.history = startValue;
        this.intimidation = startValue;
        this.medicine = startValue;
        this.nature = startValue;
        this.perception = startValue;
        this.persuasion = startValue;
        this.sleightofhand = startValue;
        this.investigation = startValue;
        this.religion = startValue;
        this.insight = startValue;
        this.survival = startValue;
        this.deception = startValue;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(Integer acrobatics) {
        this.acrobatics = acrobatics;
    }

    public Integer getAnimalhandling() {
        return animalhandling;
    }

    public void setAnimalhandling(Integer animalhandling) {
        this.animalhandling = animalhandling;
    }

    public Integer getArcana() {
        return arcana;
    }

    public void setArcana(Integer arcana) {
        this.arcana = arcana;
    }

    public Integer getAthletics() {
        return athletics;
    }

    public void setAthletics(Integer athletics) {
        this.athletics = athletics;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Integer getStealth() {
        return stealth;
    }

    public void setStealth(Integer stealth) {
        this.stealth = stealth;
    }

    public Integer getHistory() {
        return history;
    }

    public void setHistory(Integer history) {
        this.history = history;
    }

    public Integer getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(Integer intimidation) {
        this.intimidation = intimidation;
    }

    public Integer getMedicine() {
        return medicine;
    }

    public void setMedicine(Integer medicine) {
        this.medicine = medicine;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature(Integer nature) {
        this.nature = nature;
    }

    public Integer getPerception() {
        return perception;
    }

    public void setPerception(Integer perception) {
        this.perception = perception;
    }

    public Integer getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(Integer persuasion) {
        this.persuasion = persuasion;
    }

    public Integer getSleightofhand() {
        return sleightofhand;
    }

    public void setSleightofhand(Integer sleightofhand) {
        this.sleightofhand = sleightofhand;
    }

    public Integer getInvestigation() {
        return investigation;
    }

    public void setInvestigation(Integer investigation) {
        this.investigation = investigation;
    }

    public Integer getReligion() {
        return religion;
    }

    public void setReligion(Integer religion) {
        this.religion = religion;
    }

    public Integer getInsight() {
        return insight;
    }

    public void setInsight(Integer insight) {
        this.insight = insight;
    }

    public Integer getSurvival() {
        return survival;
    }

    public void setSurvival(Integer survival) {
        this.survival = survival;
    }

    public Integer getDeception() {
        return deception;
    }

    public void setDeception(Integer deception) {
        this.deception = deception;
    }
}
