package no.noroff.heroes.item;

import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.hero.HeroAttribute;

public abstract class Item {
    protected String name;
    protected int RequiredLevel;
    protected Slot slot;
    protected int weapon_damage;
    protected Armor_type armor_type;
    protected HeroAttribute armor_attribute;
    protected Weapon_type weapon_type;

    // constructor

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        RequiredLevel = requiredLevel;
        this.slot = slot;
        this.weapon_type = null;
        weapon_damage = 0;
        armor_attribute = null;
        armor_type = null;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return RequiredLevel;
    }

    public Weapon_type getWeapon_type() {
        return weapon_type;
    }

    public int getWeapon_damage() {
        return weapon_damage;
    }

    public Armor_type getArmor_type() {
        return armor_type;
    }

    public HeroAttribute getArmor_attribute() {
        return armor_attribute;
    }

    public Slot getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", RequiredLevel=" + RequiredLevel +
                ", slot=" + slot +
                ", weapon_damage=" + weapon_damage +
                ", armor_type=" + armor_type +
                ", armor_attribute=" + armor_attribute +
                ", weapon_type=" + weapon_type +
                '}';
    }
}
