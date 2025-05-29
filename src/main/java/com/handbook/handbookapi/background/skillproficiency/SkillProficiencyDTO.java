package com.handbook.handbookapi.background.skillproficiency;

import java.util.List;
import java.util.stream.Collectors;

public class SkillProficiencyDTO {

    private SkillProficiencyType skillProficiencyType;

    public SkillProficiencyDTO() {
    }

    public SkillProficiencyType getSkillProficiencyType() {
        return skillProficiencyType;
    }

    public void setSkillProficiencyType(SkillProficiencyType skillProficiencyType) {
        this.skillProficiencyType = skillProficiencyType;
    }

    public static SkillProficiencyDTO fromEntity(SkillProficiency skillProficiency) {
        SkillProficiencyDTO dto = new SkillProficiencyDTO();
        dto.setSkillProficiencyType(skillProficiency.getSkillProficiencyType());

        return dto;
    };

    public SkillProficiency toEntity() {
        SkillProficiency skillProficiency = new SkillProficiency();
        skillProficiency.setSkillProficiencyType(this.getSkillProficiencyType());

        return skillProficiency;
    };

    public static List<SkillProficiencyDTO> fromEntity(List<SkillProficiency> skillProficiencies) {
        return skillProficiencies.stream().map(SkillProficiencyDTO::fromEntity).collect(Collectors.toList());
    }
}
