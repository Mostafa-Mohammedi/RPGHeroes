package no.noroff.heroes.item;

import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.Item;

public class Weapon extends Item {

    private double weaponDamage;
    private Weapon_type weaponType;


    public Weapon(String name, int requiredLevel, Slot slot, double weaponDamage, Weapon_type weaponType) {
        super(name, requiredLevel, slot);
        this.weaponDamage = weaponDamage;
        this.weaponType = weaponType;

        //super values
    }

    // getter  setter

    public double getWeaponDamage() {
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

    @Override
    public void item_level(int requiredLevel) {

    }
}
