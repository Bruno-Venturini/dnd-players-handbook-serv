package com.handbook.handbookapi.character.race;


import com.handbook.handbookapi.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "races")
@SequenceGenerator(name = "seq_races", sequenceName = "seq_races", allocationSize = 1)
public class Race implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_languages")
    @Column(name = "id")
    private Long id;

    @Column(name = "race_type")
    @Enumerated(EnumType.STRING)
    private RaceType raceType;

    public Race() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }
}
