package com.handbook.handbookapi.character.race;

import java.util.Objects;

public class RaceDTO {

    private RaceType raceType;

    public RaceType getRaceType() {
        return raceType;
    }

    public void setRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public static RaceDTO fromEntity(Race race) {
        if (Objects.isNull(race)) {
            return null;
        }

        RaceDTO dto = new RaceDTO();
        dto.setRaceType(race.getRaceType());

        return dto;
    }

    public Race toEntity() {
        Race race = new Race();
        race.setRaceType(this.getRaceType());

        return race;
    }
}
