package com.handbook.handbookapi.character.characterclass.concrete;

import com.handbook.handbookapi.character.characterclass.CharacterClass;
import com.handbook.handbookapi.character.characterclass.behaviors.ILevelUpBehavior;
import com.handbook.handbookapi.character.characterclass.behaviors.ILongRestBehavior;
import com.handbook.handbookapi.character.characterclass.behaviors.IShortRestBehavior;
import com.handbook.handbookapi.common.Die;

public class Rogue extends CharacterClass implements ILevelUpBehavior, ILongRestBehavior, IShortRestBehavior {

    public Rogue() {
    }

    @Override
    public void levelUp() {

    }

    @Override
    public void longRest() {

    }

    @Override
    public void shortRest() {

    }

    @Override
    public Die getHitDie() {
        return new Die(8);
    }
}
