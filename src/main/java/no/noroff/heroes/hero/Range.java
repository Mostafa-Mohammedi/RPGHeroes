package no.noroff.heroes.hero;

import no.noroff.heroes.CustomException.InvalidArmorType;
import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.item.Armor;

public class Range extends Hero {

    final private int strength_increase_each_level = 1;
    final private int dexterity_increase_each_level = 5;
    final private int intelligence_increase_each_level = 1;

    private double total_range_attribute;
    private double total_range_damage;


    public Range(String name) {
        super(name);

        // level

        levelAttribute.setStrength(1);
        levelAttribute.setDexterity(7);
        levelAttribute.setIntelligence(1);

        // slot item
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.LEGS, null);

        // valid weapon type
        valid_Weapon_type.add(Weapon_type.BOWS.name());

        // valid armor type
        Valid_Armor_type.add(Armor_type.LEATHER.name());
        Valid_Armor_type.add(Armor_type.MAIL.name());


    }


    @Override
    public void damage() {
        total_range_damage = WeaponDamage * (1+ (levelAttribute.getStrength()/100));
        System.out.println("total damage: " + total_range_attribute);

    }


    @Override
    public double totalAttributes() {
        total_range_attribute = (levelAttribute.getStrength() +
                levelAttribute.getDexterity() +
                levelAttribute.getIntelligence()) +
                (WeaponDamage + armor_attribute);
        return total_range_attribute;
    }

    @Override
    public String display() {
        return "name: " + name +
                " class: " + this.getClass().getSimpleName() +
                " level: " + level +
                " strength: " +  levelAttribute.getStrength() +
                " dexterity: " +levelAttribute.getDexterity() +
                " intelligence: " + levelAttribute.getIntelligence() +
                " Damage " + total_range_damage;
    }
}
