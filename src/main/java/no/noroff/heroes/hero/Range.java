package no.noroff.heroes.hero;

import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;

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
    public void levelUp(double level_increase) {

    }

    @Override
    public void damage() {

    }

    @Override
    public String equip_armor(String armor_type, double armor_level) throws InvalidWeaponType {
        return null;
    }

    @Override
    public String equip_weapon(String weapon_type, double weapon_level) throws InvalidWeaponType {
        return null;
    }

    @Override
    public void totalAttributes() {

    }

    @Override
    public String display() {
        return null;
    }
}
