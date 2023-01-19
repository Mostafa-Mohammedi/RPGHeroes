package no.noroff.heroes.item;

import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.hero.HeroAttribute;

/**
 * Armor class is used for equipping the hero with an armor
 */
public class Armor extends Item {

    Armor_type armorType;
    HeroAttribute armorAttribute;


    /**
     * Constructor for creating an instance of the Armor
     * @param name String for naming the weapon
     * @param requiredLevel int for entering the armor level
     * @param slot Enum for initializing where the weapon belong
     * @param armorType Enum containing all the weapon type
     * @param armorAttribute  An instance of armor attribute for giving the armor attribute
     */
    public Armor(String name, int requiredLevel, Slot slot, Armor_type armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
        armor_type = armorType;
        armor_attribute = armorAttribute;
    }

    //getter setter

    /**
     * Getter for getting the enum armor type instance
     * @return an armor type enum value
     */
    public Armor_type getArmorType() {
        return armorType;
    }

    /**
     * Getter for getting the name of the armor
     * @return armor name in string
     */
    public String get_armor_name(){
        return name;
    }

    /**
     * Getter for getting the armor level
     * @return armor level in int
     */
    public int get_armor_level(){
        return this.RequiredLevel;
    }

    /**
     * getter for getting the slot for equipping the armor hero
     * @return return the slot name in string format
     */
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
