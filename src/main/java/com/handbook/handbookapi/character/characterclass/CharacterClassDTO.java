package com.handbook.handbookapi.character.characterclass;

import java.util.Objects;

public class CharacterClassDTO {

    private ClassType classType;

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public static CharacterClassDTO fromEntity(CharacterClass characterClass) {
        if(Objects.isNull(characterClass)) {
            return null;
        }
        CharacterClassDTO dto = new CharacterClassDTO();
        dto.setClassType(characterClass.getClassType());

        return dto;
    }

    public CharacterClass toEntity() {
        CharacterClass characterClass = new CharacterClass();
        characterClass.setClassType(this.getClassType());

        return characterClass;
    }
}
