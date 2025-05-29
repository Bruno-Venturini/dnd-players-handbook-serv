package com.handbook.handbookapi.common;

import java.util.Random;

public class Die {

    Random random = new Random();

    private Integer sides;

    public Die(Integer sides) {
        this.sides = sides;
    }

    public Integer roll() {
        return random.nextInt(sides) + 1;
    }

    @Override
    public String toString() {
        return "1d" + sides;
    }
}
