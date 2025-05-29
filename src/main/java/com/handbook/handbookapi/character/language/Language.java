package com.handbook.handbookapi.character.language;

import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "languages")
@SequenceGenerator(name = "seq_languages", sequenceName = "seq_languages", allocationSize = 1)
public class Language implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_languages")
    @Column(name = "id")
    private Long id;

    @Column(name = "language_type")
    @Enumerated(EnumType.STRING)
    private LanguageType languageType;

    public Language() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LanguageType getLanguageType() {
        return languageType;
    }

    public void setLanguageType(LanguageType languageType) {
        this.languageType = languageType;
    }
}