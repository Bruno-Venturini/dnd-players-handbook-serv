package com.handbook.handbookapi.background.toolproficiency;

import java.util.List;
import java.util.stream.Collectors;

public class ToolProficiencyDTO {

    private ToolProficiencyType toolProficiencyType;

    public ToolProficiencyType getToolProficiencyType() {
        return toolProficiencyType;
    }

    public void setToolProficiencyType(ToolProficiencyType toolProficiencyType) {
        this.toolProficiencyType = toolProficiencyType;
    }

    public static ToolProficiencyDTO fromEntity(ToolProficiency toolProficiency) {
        ToolProficiencyDTO dto = new ToolProficiencyDTO();
        dto.setToolProficiencyType(toolProficiency.getToolProficiencyType());

        return dto;
    };

    public ToolProficiency toEntity() {
        ToolProficiency toolProficiency = new ToolProficiency();
        toolProficiency.setToolProficiencyType(this.getToolProficiencyType());

        return toolProficiency;
    };

    public static List<ToolProficiencyDTO> fromEntity(List<ToolProficiency> toolProficiencies) {
        return toolProficiencies.stream().map(ToolProficiencyDTO::fromEntity).collect(Collectors.toList());
    }
}
