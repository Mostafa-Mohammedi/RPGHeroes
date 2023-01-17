package no.noroff.heroes.hero;

import no.noroff.heroes.CustomException.InvalidArmorType;
import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.item.Item;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.item.Armor;
import no.noroff.heroes.item.Weapon;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Abstract hero class to add main features the heroes
 *
 */
public abstract class Hero {
    String name;
    int level = 1;
    double weapon_damage;
    double total_weapon_Damage;
    double armor_attribute;
    double total_strength_increase;

    double total_dexterity_Increase;
    double total_intelligence_increase;

    protected HeroAttribute levelAttribute;
    protected HashMap<Slot, Item> equipment;
    ArrayList<String> valid_Weapon_type;
    ArrayList<String> Valid_Armor_type;

    public Hero(String name) {
        this.name = name;
        equipment = new HashMap<Slot, Item>();
        valid_Weapon_type = new ArrayList<String>();
        Valid_Armor_type = new ArrayList<String>();
        levelAttribute = new HeroAttribute();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getTotal_strength_Increase() {
        return total_strength_increase;
    }

    public double getTotal_dexterity_Increase() {
        return total_dexterity_Increase;
    }

    public double getTotal_intelligence_increase() {
        return total_intelligence_increase;
    }

    public HeroAttribute getLevelAttribute() {
        return levelAttribute;
    }


    /**
     * Method for leveling up the hero and the heroes attribute.
     * @param level_increase double level increase
     * @param strength_increase_each_level double strength increase
     * @param dexterity_increase_each_level double dexterity increase
     * @param intelligence_increase_each_level double intelligence increase
     * @return return the new level
     */
    public int levelUp(double level_increase, double strength_increase_each_level, double dexterity_increase_each_level, double intelligence_increase_each_level) {

         total_strength_increase = (level_increase * strength_increase_each_level) + levelAttribute.getStrength();
         total_dexterity_Increase = (level_increase * dexterity_increase_each_level) + levelAttribute.getDexterity();
         total_intelligence_increase = (level_increase * intelligence_increase_each_level) + levelAttribute.getIntelligence();

        levelAttribute.setStrength(total_strength_increase) ;
        levelAttribute.setDexterity(total_dexterity_Increase);
        levelAttribute.setIntelligence(total_intelligence_increase);

        return level += level_increase;
    }

    /**
     * method for calculating the damage a hero can inflict
     */
    public abstract void damage();

    /**
     * method for equipping an armor to hero.
     * @param armor takes an instance of the armor class
     * @return return a string value confirming the new hero has been equipped
     * @throws InvalidArmorType throw a custom exception if the hero tries to equip wrong armor type
     * @throws InvalidLevel throw a custom exception if a hero tries to equip a armor that has a higher level then the hero level
     */
    public  String equip_armor(Armor armor) throws InvalidArmorType, InvalidLevel{
        for (String equipment : Valid_Armor_type) {

            if(equipment.equalsIgnoreCase(armor.getArmorType().name()) && armor.get_armor_level() == level){
                weapon_damage += armor.getArmorAttribute().getStrength();
                armor_attribute += armor.getArmorAttribute().getStrength();

                return "equipment: " + armor.getArmorType().name().toLowerCase() + " has been added to " + name;
            }
            else if (equipment.equalsIgnoreCase(armor.getArmorType().name()) && armor.get_armor_level() != level){
                throw new InvalidLevel(name);
            }
        }

        throw new InvalidArmorType( armor.getArmorType().name().toLowerCase() + " cannot be used for " + this.getClass().getSimpleName() + " hero ");
    }

    /**
     * method for removing hero armor of hero
     * @param armor takes an armor instance
     * @return return a string confirming that the armor has been removed
     */
    public  String remove_armor(Armor armor) {
        armor_attribute -= armor.getArmorAttribute().getStrength();
        weapon_damage -= armor.getArmorAttribute().getStrength();
        return "item has been removed";
    }

    /**
     * method for equipping a weapon to hero.
     * add the attribute to hero for weapon damage
     * @param weapon take  a weapon instance as a parameter to get acces to the attribute
     * @return a string confirming that the hero has been equipped with a weapon
     * @throws InvalidLevel a custom exception that the weapon level is too high
     * @throws InvalidWeaponType a custom exception that the hero tries to equip a wrong weapon type
     */
    public String equip_weapon(Weapon weapon) throws InvalidLevel, InvalidWeaponType {

        for (String equipment : valid_Weapon_type) {
            if (equipment.equalsIgnoreCase(weapon.getWeaponType().name()) && weapon.get_weapon_level() == level) {
                weapon_damage += weapon.getWeaponDamage();
                return name + " has been equip with " + weapon.get_weapon_name();

            }
            else if(equipment.equalsIgnoreCase(weapon.getWeaponType().name()) && weapon.get_weapon_level() != level){
                throw new InvalidLevel(name);
            }
        }
        throw new InvalidWeaponType(weapon.getWeaponType().name().toLowerCase(),  this.getClass().getSimpleName());
    }

    /**
     * method for calculating the total hero attribute that consist of strength dexterity and intelligence
     * @return a value that contains the heroes total attribute
     */
    public abstract double totalAttributes();

    /**
     * Method for showing the heroes state
     * @return a string value containing the heroes Name, class, level, total strength, total dexterity total intelligence and damage
     */

    public abstract String display();

}
