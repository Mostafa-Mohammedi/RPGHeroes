package no.noroff.heroes.item;

import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Weapon_type;

public class Weapon extends Item {

    private int weaponDamage;
    private Weapon_type weaponType;


    public Weapon(String name, int requiredLevel, Slot slot, int weaponDamage, Weapon_type weaponType) {
        super(name, requiredLevel, slot);
        this.weaponDamage = weaponDamage;
        this.weaponType = weaponType;
        weapon_type = weaponType;
        weapon_damage = weaponDamage;
    }

    // getter and setter
    public int getWeaponDamage() {
        return weaponDamage;
    }

    public Weapon_type getWeaponType() {
        return weaponType;
    }

    // Method
    public String get_weapon_name(){
        return name;
    }
    public int get_weapon_level(){
        return this.RequiredLevel;
    }
    public String get_slot(){
        return slot.name();
    }

}
