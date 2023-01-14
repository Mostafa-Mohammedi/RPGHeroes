package no.noroff.heroes.item;

import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.Item;

public class Weapon extends Item {

    double weaponDamage;
    Weapon_type weaponType;

    public Weapon(String name, int requiredLevel) {
        super(name, requiredLevel);
    }



    @Override
    public void item_level(int requiredLevel) {

    }
}
