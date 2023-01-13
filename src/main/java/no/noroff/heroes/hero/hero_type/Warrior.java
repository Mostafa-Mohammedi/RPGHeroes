package no.noroff.heroes.hero.hero_type;

import no.noroff.heroes.hero.Hero;

public class Warrior extends  Hero{

    //constructor
    public Warrior(String name) {
        super(name);
        levelAttribute.setStrength(5);
        levelAttribute.setDexterity(2);
        levelAttribute.setIntelligence(1);
    }


    // method
    @Override
    public void levelUp(double level_increase) {

    }

    @Override
    public void damage() {

    }

    @Override
    public void equip() {

    }

    @Override
    public void totalAttributes() {

    }

    @Override
    public void display() {

    }

    @Override
    public String toString() {
        return "level " + levelAttribute.getStrength() + " dexterity " +  levelAttribute.getDexterity() + " intelligence " + levelAttribute.getIntelligence();
    }
}
