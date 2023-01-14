package no.noroff.heroes.hero;

import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.hero.Hero;

public class Warrior extends Hero{

    //constructor
    public Warrior(String name) {
        super(name);

        // level

        levelAttribute.setStrength(5);
        levelAttribute.setDexterity(2);
        levelAttribute.setIntelligence(1);

        // slot item
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.LEGS, null);

        // valid weapon type
        valid_Weapon_type.add(Weapon_type.AXES.name());
        valid_Weapon_type.add(Weapon_type.HAMMERS.name());
        valid_Weapon_type.add(Weapon_type.SWORDS.name());
    }


    // method
    @Override
    public void levelUp(double level_increase) {

    }

    @Override
    public void damage() {

    }

    @Override
    public void equip_armor(String armor_type, double armor_level) {

    }

    @Override
    public String equip_weapon(String weapon_type, double weapon_level) throws InvalidWeaponType {

        for (String weapon : valid_Weapon_type) {

            if(weapon.toUpperCase().equals(weapon_type) && weapon_level == level){
                System.out.println("equipment: " + weapon_type + " has been added to warrior");
                return "equipment: " + weapon_type + " has been added to warrior";
            }
        }
        throw new InvalidWeaponType(weapon_type + " cannot be used for Warrior");
    }


    @Override
    public void totalAttributes() {

    }

    @Override
    public void display() {

    }

    @Override
    public String toString() {
        return "level " + levelAttribute.getStrength() + " dexterity " +  levelAttribute.getDexterity() + " intelligence " + levelAttribute.getIntelligence() + " weapon " + equipment + " weapon type " + valid_Weapon_type;
    }
}
