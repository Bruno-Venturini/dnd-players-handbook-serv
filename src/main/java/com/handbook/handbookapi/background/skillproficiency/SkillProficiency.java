package com.handbook.handbookapi.background.skillproficiency;

import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "skill_proficiencies")
@SequenceGenerator(name = "seq_skill_proficiencies", sequenceName = "seq_skill_proficiencies", allocationSize = 1)
public class SkillProficiency implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_skill_proficiencies")
    @Column(name = "id")
    private Long id;

    @Column(name = "skill_proficiency_type")
    @Enumerated(EnumType.STRING)
    private SkillProficiencyType skillProficiencyType;

    public SkillProficiency() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public SkillProficiencyType getSkillProficiencyType() {
        return skillProficiencyType;
    }

    public void setSkillProficiencyType(SkillProficiencyType skillProficiencyType) {
        this.skillProficiencyType = skillProficiencyType;
    }
}
