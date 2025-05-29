package com.handbook.handbookapi.background;

import com.handbook.handbookapi.background.skillproficiency.SkillProficiency;
import com.handbook.handbookapi.background.toolproficiency.ToolProficiency;
import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "backgrounds")
@SequenceGenerator(name = "seq_backgrounds", sequenceName = "seq_backgrounds", allocationSize = 1)
public class Background implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_backgrounds")
    @Column(name = "id")
    private Long id;

    @Column(name = "background_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BackgroundType backgroundType;

    @Column(name = "extra_languages")
    private Integer extraLanguages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "background_skill_proficiencies",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_proficiency_id"))
    private List<SkillProficiency> skillProficiencies;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "background_tool_proficiencies",
            joinColumns = @JoinColumn(name = "background_id"),
            inverseJoinColumns = @JoinColumn(name = "tool_proficiency_id"))
    private List<ToolProficiency> toolProficiencies;

    public Background() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public List<SkillProficiency> getSkillProficiencies() {
        return skillProficiencies;
    }

    public void setSkillProficiencies(List<SkillProficiency> skillProficiencies) {
        this.skillProficiencies = skillProficiencies;
    }

    public List<ToolProficiency> getToolProficiencies() {
        return toolProficiencies;
    }

    public void setToolProficiencies(List<ToolProficiency> toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }
}
