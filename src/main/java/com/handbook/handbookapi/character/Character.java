package com.handbook.handbookapi.character;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.handbook.handbookapi.background.Background;
import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.language.Language;
import com.handbook.handbookapi.character.race.Race;
import com.handbook.handbookapi.common.BaseEntity;
import com.handbook.handbookapi.skill.Skill;
import com.handbook.handbookapi.spell.Spell;
import com.handbook.handbookapi.user.User;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GenerationType;

@Entity
@Table(name = "characters")
@SequenceGenerator(name = "seq_characters", sequenceName = "seq_characters", allocationSize = 1)
public class Character implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_characters")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "background_id")
    private Background background;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "character_languages",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> languages;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "character_spells",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "spell_id"))
    private List<Spell> spells;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "race_id")
    private Race race;

    @Column(name = "experience")
    private Integer experience;

    @Column(name = "proficiency")
    private Integer proficiency;

    @Column(name = "armor_class")
    private Integer armorClass;

    @Column(name = "initiative")
    private Integer initiative;

    @Column(name = "move_speed")
    private Integer moveSpeed;

    @Column(name = "life")
    private Integer life;

    @Column(name = "hit_die")
    private String hitDie;

    @Column(name = "temporary_life")
    private Integer temporaryLife;

    @Column(name = "description")
    private String description;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private CharacterClass characterClass;

    @Column(name = "level")
    private Integer level;

    @Column(name = "intelligence")
    private Integer intelligence = 0;

    @Column(name = "strength")
    private Integer strength = 0;

    @Column(name = "constitution")
    private Integer constitution = 0;

    @Column(name = "wisdom")
    private Integer wisdom = 0;

    @Column(name = "dexterity")
    private Integer dexterity = 0;

    @Column(name = "charisma")
    private Integer charisma = 0;

    @Column(name = "is_completed")
    private Boolean isCompleted = Boolean.FALSE;

    public Character() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getProficiency() {
        return proficiency;
    }

    public void setProficiency(Integer proficiency) {
        this.proficiency = proficiency;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getInitiative() {
        return initiative;
    }

    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    public Integer getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(Integer moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public String getHitDie() {
        return hitDie;
    }

    public void setHitDie(String hitDie) {
        this.hitDie = hitDie;
    }

    public Integer getTemporaryLife() {
        return temporaryLife;
    }

    public void setTemporaryLife(Integer temporaryLife) {
        this.temporaryLife = temporaryLife;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public void setAllAttributes(Integer value) {
        this.intelligence = value;
        this.strength = value;
        this.constitution = value;
        this.wisdom = value;
        this.dexterity = value;
        this.charisma = value;
    }

    public void sumAttributes(Integer intelligence, Integer strength, Integer constitution,
                              Integer wisdom, Integer dexterity, Integer charisma) {
        this.intelligence += intelligence;
        this.strength += strength;
        this.constitution += constitution;
        this.wisdom += wisdom;
        this.dexterity += dexterity;
        this.charisma += charisma;
    }

    public void sumAllAttributes(Integer value) {
        this.intelligence += value;
        this.strength += value;
        this.constitution += value;
        this.wisdom += value;
        this.dexterity += value;
        this.charisma += value;
    }

    public void sumIntelligence(Integer intelligence) {
        this.intelligence += intelligence;
    }

    public void sumStrength(Integer strength) {
        this.strength += strength;
    }

    public void sumConstitution(Integer constitution) {
        this.constitution += constitution;
    }

    public void sumWisdom(Integer wisdom) {
        this.wisdom += wisdom;
    }

    public void sumDexterity(Integer dexterity) {
        this.dexterity += dexterity;
    }

    public void sumCharisma(Integer charisma) {
        this.charisma += charisma;
    }

    public List<Integer> getAllAttributes() {
        List<Integer> allAttributes = new ArrayList<>();

        allAttributes.add(this.intelligence);
        allAttributes.add(this.charisma);
        allAttributes.add(this.strength);
        allAttributes.add(this.wisdom);
        allAttributes.add(this.dexterity);
        allAttributes.add(this.constitution);

        return allAttributes;
    }
}
