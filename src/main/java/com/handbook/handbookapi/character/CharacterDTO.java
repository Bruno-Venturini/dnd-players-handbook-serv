package com.handbook.handbookapi.character;

import com.handbook.handbookapi.background.BackgroundDTO;
import com.handbook.handbookapi.character.characterclass.CharacterClassDTO;
import com.handbook.handbookapi.character.language.LanguageDTO;
import com.handbook.handbookapi.character.race.RaceDTO;
import com.handbook.handbookapi.skill.SkillDTO;
import com.handbook.handbookapi.spell.SpellDTO;
import com.handbook.handbookapi.user.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterDTO {

    private Long id;
    private String name;
    private BackgroundDTO background;
    private UserDTO user;
    private SkillDTO skill;
    private List<LanguageDTO> languages;
    private List<SpellDTO> spells;
    private RaceDTO race;
    private Integer experience;
    private Integer proficiency;
    private Integer armorClass;
    private Integer initiative;
    private Integer moveSpeed;
    private Integer life;
    private Integer temporaryLife;
    private String description;
    private CharacterClassDTO characterClass;
    private Integer level;
    private Integer intelligence;
    private Integer strength;
    private Integer constitution;
    private Integer wisdom;
    private Integer dexterity;
    private Integer charisma;
    private Boolean isCompleted;

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

    public BackgroundDTO getBackground() {
        return background;
    }

    public void setBackground(BackgroundDTO background) {
        this.background = background;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public SkillDTO getSkill() {
        return skill;
    }

    public void setSkill(SkillDTO skill) {
        this.skill = skill;
    }

    public List<LanguageDTO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageDTO> languages) {
        this.languages = languages;
    }

    public List<SpellDTO> getSpells() {
        return spells;
    }

    public void setSpells(List<SpellDTO> spells) {
        this.spells = spells;
    }

    public RaceDTO getRace() {
        return race;
    }

    public void setRace(RaceDTO race) {
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

    public CharacterClassDTO getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClassDTO characterClass) {
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

    public static CharacterDTO fromEntity(Character character) {
        CharacterDTO dto = new CharacterDTO();

        dto.setId(character.getId());
        dto.setName(character.getName());
        dto.setBackground(BackgroundDTO.fromEntity(character.getBackground()));
        dto.setUser(UserDTO.fromEntity(character.getUser()));
        dto.setSkill(SkillDTO.fromEntity(character.getSkill()));
        dto.setLanguages(LanguageDTO.fromEntity(character.getLanguages()));
        dto.setSpells(SpellDTO.fromEntity(character.getSpells()));
        dto.setRace(RaceDTO.fromEntity(character.getRace()));
        dto.setExperience(character.getExperience());
        dto.setProficiency(character.getProficiency());
        dto.setArmorClass(character.getArmorClass());
        dto.setInitiative(character.getInitiative());
        dto.setMoveSpeed(character.getMoveSpeed());
        dto.setLife(character.getLife());
        dto.setTemporaryLife(character.getTemporaryLife());
        dto.setDescription(character.getDescription());
        dto.setCharacterClass(CharacterClassDTO.fromEntity(character.getCharacterClass()));
        dto.setLevel(character.getLevel());
        dto.setIntelligence(character.getIntelligence());
        dto.setStrength(character.getStrength());
        dto.setConstitution(character.getConstitution());
        dto.setWisdom(character.getWisdom());
        dto.setDexterity(character.getDexterity());
        dto.setCharisma(character.getCharisma());
        dto.setCompleted(character.getCompleted());

        return dto;
    }

    public Character toEntity() {
        Character character = new Character();

        character.setName(character.getName());
        character.setBackground(this.getBackground().toEntity());
        character.setUser(this.getUser().toEntity());
        character.setSkill(this.getSkill().toEntity());
        character.setLanguages(this.getLanguages().stream().map(LanguageDTO::toEntity).collect(Collectors.toList()));
        character.setSpells(this.getSpells().stream().map(SpellDTO::toEntity).collect(Collectors.toList()));
        character.setRace(this.getRace().toEntity());
        character.setExperience(character.getExperience());
        character.setProficiency(character.getProficiency());
        character.setArmorClass(character.getArmorClass());
        character.setInitiative(character.getInitiative());
        character.setMoveSpeed(character.getMoveSpeed());
        character.setLife(character.getLife());
        character.setTemporaryLife(character.getTemporaryLife());
        character.setDescription(character.getDescription());
        character.setCharacterClass(this.getCharacterClass().toEntity());
        character.setLevel(character.getLevel());
        character.setIntelligence(character.getIntelligence());
        character.setStrength(character.getStrength());
        character.setConstitution(character.getConstitution());
        character.setWisdom(character.getWisdom());
        character.setDexterity(character.getDexterity());
        character.setCharisma(character.getCharisma());
        character.setCompleted(character.getCompleted());

        return character;
    }

    public static List<CharacterDTO> fromEntity(List<Character> characters) {
        List<CharacterDTO> charactersFind = characters.stream().map(character -> fromEntity(character)).collect(Collectors.toList());
        return charactersFind;
    }

    public static Page<CharacterDTO> fromEntity(Page<Character> characters) {
        List<CharacterDTO> charactersFind = characters.stream().map(character -> fromEntity(character)).collect(Collectors.toList());
        Page<CharacterDTO> charactersDTO = new PageImpl<>(charactersFind, characters.getPageable(), characters.getTotalElements());
        return charactersDTO;
    }
}
