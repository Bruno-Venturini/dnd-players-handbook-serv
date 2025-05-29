package com.handbook.handbookapi.skill;

import java.util.Objects;

public class SkillDTO {

    private Integer acrobatics;
    private Integer animalHandling;
    private Integer arcana;
    private Integer athletics;
    private Integer performance;
    private Integer stealth;
    private Integer history;
    private Integer intimidation;
    private Integer medicine;
    private Integer nature;
    private Integer perception;
    private Integer persuasion;
    private Integer sleightOfHand;
    private Integer investigation;
    private Integer religion;
    private Integer insight;
    private Integer survival;
    private Integer deception;

    public SkillDTO() {
    }

    public Integer getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(Integer acrobatics) {
        this.acrobatics = acrobatics;
    }

    public Integer getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(Integer animalHandling) {
        this.animalHandling = animalHandling;
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

    public Integer getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(Integer sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
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

    public static SkillDTO fromEntity(Skill skill) {
        if (Objects.isNull(skill)) {
            return null;
        }
        SkillDTO dto = new SkillDTO();
        dto.setAcrobatics(skill.getAcrobatics());
        dto.setAnimalHandling(skill.getAnimalhandling());
        dto.setArcana(skill.getArcana());
        dto.setAthletics(skill.getAthletics());
        dto.setPerformance(skill.getPerformance());
        dto.setStealth(skill.getStealth());
        dto.setHistory(skill.getHistory());
        dto.setIntimidation(skill.getIntimidation());
        dto.setMedicine(skill.getMedicine());
        dto.setNature(skill.getNature());
        dto.setPerception(skill.getPerception());
        dto.setPersuasion(skill.getPersuasion());
        dto.setSleightOfHand(skill.getSleightofhand());
        dto.setInvestigation(skill.getInvestigation());
        dto.setReligion(skill.getReligion());
        dto.setInsight(skill.getInsight());
        dto.setSurvival(skill.getSurvival());
        dto.setDeception(skill.getDeception());

        return dto;
    }

    public Skill toEntity() {
        Skill skill = new Skill();
        skill.setAcrobatics(this.getAcrobatics());
        skill.setAnimalhandling(this.getAnimalHandling());
        skill.setArcana(this.getArcana());
        skill.setAthletics(this.getAthletics());
        skill.setPerformance(this.getPerformance());
        skill.setStealth(this.getStealth());
        skill.setHistory(this.getHistory());
        skill.setIntimidation(this.getIntimidation());
        skill.setMedicine(this.getMedicine());
        skill.setNature(this.getNature());
        skill.setPerception(this.getPerception());
        skill.setPersuasion(this.getPersuasion());
        skill.setSleightofhand(this.getSleightOfHand());
        skill.setInvestigation(this.getInvestigation());
        skill.setReligion(this.getReligion());
        skill.setInsight(this.getInsight());
        skill.setSurvival(this.getSurvival());
        skill.setDeception(this.getDeception());

        return skill;
    }
}
