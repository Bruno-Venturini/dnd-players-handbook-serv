package com.handbook.handbookapi.background;

import com.handbook.handbookapi.background.skillproficiency.SkillProficiencyDTO;
import com.handbook.handbookapi.background.toolproficiency.ToolProficiencyDTO;

import java.util.List;
import java.util.Objects;


public class BackgroundDTO {

    private BackgroundType backgroundType;
    private Integer extraLanguages;
    private List<SkillProficiencyDTO> skillProficiencies;
    private List<ToolProficiencyDTO> toolProficiencies;

    public BackgroundDTO() {
    }

    public BackgroundType getBackgroundType() {
        return backgroundType;
    }

    public void setBackgroundType(BackgroundType backgroundType) {
        this.backgroundType = backgroundType;
    }

    public Integer getExtraLanguages() {
        return extraLanguages;
    }

    public void setExtraLanguages(Integer extraLanguages) {
        this.extraLanguages = extraLanguages;
    }

    public List<SkillProficiencyDTO> getSkillProficiencies() {
        return skillProficiencies;
    }

    public void setSkillProficiencies(List<SkillProficiencyDTO> skillProficiencies) {
        this.skillProficiencies = skillProficiencies;
    }

    public List<ToolProficiencyDTO> getToolProficiencies() {
        return toolProficiencies;
    }

    public void setToolProficiencies(List<ToolProficiencyDTO> toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }

    public static BackgroundDTO fromEntity(Background background) {
        if (Objects.isNull(background)) {
            return null;
        }

        BackgroundDTO dto = new BackgroundDTO();

        dto.setBackgroundType(background.getBackgroundType());
        dto.setExtraLanguages(background.getExtraLanguages());
        dto.setToolProficiencies(ToolProficiencyDTO.fromEntity(background.getToolProficiencies()));
        dto.setSkillProficiencies(SkillProficiencyDTO.fromEntity(background.getSkillProficiencies()));

        return dto;
    }

    public Background toEntity() {
        Background background = new Background();
        background.setBackgroundType(this.getBackgroundType());
        background.setExtraLanguages(this.getExtraLanguages());

        return background;
    }

}
