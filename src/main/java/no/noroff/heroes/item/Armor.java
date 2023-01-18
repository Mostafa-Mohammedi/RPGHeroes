package no.noroff.heroes.item;

import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.hero.HeroAttribute;

public class Armor extends Item {

    Armor_type armorType;
    HeroAttribute armorAttribute;


    public Armor(String name, int requiredLevel, Slot slot, Armor_type armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
        armor_type = armorType;
        armor_attribute = armorAttribute;
    }





    //getter setter


    public Armor_type getArmorType() {
        return armorType;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    // method
    public String get_armor_name(){
        return name;
    }
    public int get_armor_level(){
        return this.RequiredLevel;
    }
    public String get_slot(){
        return slot.name();
    }

    @Override
    public String toString() {
        return "Armor{" +
                "armorType=" + armorType +
                ", armorAttribute=" + armorAttribute +
                ", name='" + name + '\'' +
                ", RequiredLevel=" + RequiredLevel +
                ", slot=" + slot +
                ", weapon_damage=" + weapon_damage +
                ", armor_type=" + armor_type +
                ", armor_attribute=" + armor_attribute +
                ", weapon_type=" + weapon_type +
                '}';
    }
}
