package no.noroff.heroes.hero;

import no.noroff.heroes.Equipment.Items;

import java.util.List;

/**
 * Abstract hero class to add main features all the main features for the heroes.
 */
public abstract class Hero {
    String name;
    double level;

    HeroAttribute levelAttribute;

    List<Items> equipment;
    List<String> valid_Weapon_type;
    List<String> getValid_Armor_type;

    public Hero(String name) {
        this.name = name;
        level = 1;
    }

    public abstract void levelUp(double level_increase);
    public abstract void damage();
    public abstract void equip();
    public abstract void totalAttributes();

    public abstract void display();




}
