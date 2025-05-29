package com.handbook.handbookapi.background.toolproficiency;

import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tool_proficiencies")
@SequenceGenerator(name = "seq_tool_proficiencies", sequenceName = "seq_tool_proficiencies", allocationSize = 1)
public class ToolProficiency implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tool_proficiencies")
    @Column(name = "id")
    private Long id;

    @Column(name = "tool_proficiency_type")
    @Enumerated(EnumType.STRING)
    private ToolProficiencyType toolProficiencyType;

    public ToolProficiency() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ToolProficiencyType getToolProficiencyType() {
        return toolProficiencyType;
    }

    public void setToolProficiencyType(ToolProficiencyType toolProficiencyType) {
        this.toolProficiencyType = toolProficiencyType;
    }
}
