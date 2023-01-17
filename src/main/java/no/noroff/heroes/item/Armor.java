package no.noroff.heroes.item;

import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.HeroAttribute;
import no.noroff.heroes.Item;

public class Armor extends Item {

    Armor_type armorType;
    HeroAttribute armorAttribute;


    public Armor(String name, int requiredLevel, Slot slot, Armor_type armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
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
    public void item_level(int requiredLevel) {

    }
}
