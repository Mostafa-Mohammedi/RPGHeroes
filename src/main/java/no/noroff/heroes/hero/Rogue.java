package no.noroff.heroes.hero;

import no.noroff.heroes.CustomException.InvalidWeaponType;

public class Rogue extends Hero{
    public Rogue(String name) {
        super(name);
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
