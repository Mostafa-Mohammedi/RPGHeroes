package no.noroff.heroes.hero;

import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.Item;
import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.HeroAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Abstract hero class to add main features all the main features for the heroes.
 */
public abstract class Hero {
    String name;
    double level = 1;


    protected HeroAttribute levelAttribute;
    protected HashMap<Slot, Item> equipment;
    ArrayList<String> valid_Weapon_type;
    ArrayList<String> Valid_Armor_type;

    public Hero(String name) {
        this.name = name;
        this.levelAttribute = new HeroAttribute();
        equipment = new HashMap<Slot, Item>();
        valid_Weapon_type = new ArrayList<String>();



    }

    public abstract void levelUp(double level_increase);
    public abstract void damage();
    public abstract void equip_armor(String armor_type, double armor_level);

    public abstract String equip_weapon(String weapon_type, double weapon_level) throws InvalidWeaponType;

    public abstract void totalAttributes();

    public abstract void display();



}
