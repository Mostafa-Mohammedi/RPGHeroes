package no.noroff.heroes.hero;
import no.noroff.heroes.CustomException.InvalidArmorType;
import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.item.Item;
import no.noroff.heroes.equipment.Slot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Abstract hero class to add main features for heroes
 * All the heroes extends the method and the variable from the hero class
 * @author Mostafa Mohammedi

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
    ArrayList<Weapon_type> valid_Weapon_type;
    ArrayList<Armor_type> Valid_Armor_type;

    public Hero(String name) {
        this.name = name;
        equipment = new HashMap<Slot, Item>();
        valid_Weapon_type = new ArrayList<Weapon_type>();
        Valid_Armor_type = new ArrayList<Armor_type>();
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
     * @param armor takes an instance of the Item class
     * @return return a string value confirming the new hero has been equipped
     * @throws InvalidArmorType throw a custom exception if the hero tries to equip wrong armor type
     * @throws InvalidLevel throw a custom exception if a hero tries to equip a armor that has a higher level then the hero level
     */
    public  String equip_armor(Item armor) throws InvalidArmorType, InvalidLevel{
        for (Armor_type equipment_armor : Valid_Armor_type) {

            if(equipment_armor.equals(armor.getArmor_type()) && armor.getRequiredLevel() == level){
                weapon_damage += armor.getArmor_attribute().getStrength();
                armor_attribute += armor.getArmor_attribute().getStrength();
                equipment.replace(armor.getSlot(), armor);
                System.out.println("testing armor: " + equipment);

                return "equipment: " + armor.getArmor_type().name().toLowerCase() + " has been added to " + name;
            }
            else if (equipment_armor.equals(armor.getArmor_type()) && armor.getRequiredLevel() != level){
                throw new InvalidLevel(name);
            }
        }

        throw new InvalidArmorType( armor.getArmor_type().name().toLowerCase() + " cannot be used for " + this.getClass().getSimpleName() + " hero ");
    }

    /**
     * method for removing hero armor of hero
     * @param armor takes an Item instance
     * @return return a string confirming that the armor has been removed
     */
    public  String remove_armor(Item armor) {
        armor_attribute -= armor.getArmor_attribute().getStrength();
        weapon_damage -= armor.getArmor_attribute().getStrength();
        return "item has been removed";
    }
    /**
     * method for equipping Item  to hero.
     * add the attribute to hero for weapon damage
     * @param weapon take  a weapon instance as a parameter to get access to the attribute
     * @return a string confirming that the hero has been equipped with a weapon
     * @throws InvalidLevel a custom exception that the weapon level is too high
     * @throws InvalidWeaponType a custom exception that the hero tries to equip a wrong weapon type
     */
    public String equip_weapon(Item weapon) throws InvalidLevel, InvalidWeaponType {


        for (Weapon_type equipments : valid_Weapon_type) {
            if (equipments.equals(weapon.getWeapon_type()) && weapon.getRequiredLevel() == level) {
                weapon_damage += weapon.getWeapon_damage();
                equipment.replace(weapon.getSlot(), weapon);
                System.out.println("testing hashmaps: " + equipment);
                return name + " has been equip with " + weapon.getName();

            } else if (equipments.equals(weapon.getWeapon_type()) && weapon.getRequiredLevel() != level) {
                throw new InvalidLevel(name);
            }
        }
        throw new InvalidWeaponType(weapon.getWeapon_type().name().toLowerCase(),  this.getClass().getSimpleName());
    }

    /**
     * method for calculating the total hero attribute that consist of strength dexterity and intelligence including armor
     * @return a new instance of the hero attribute
     */
    public HeroAttribute  totalAttributes(){
        double totalStrength = levelAttribute.getStrength();
        double totalDexterity = levelAttribute.getDexterity();
        double totalIntelligence = levelAttribute.getIntelligence();

        for (Map.Entry<Slot, Item> set : equipment.entrySet()) {
            if (!set.getKey().equals(Slot.WEAPON) && set.getValue() != null) {
                totalStrength += set.getValue().getArmor_attribute().getStrength();
                totalDexterity += set.getValue().getArmor_attribute().getDexterity();
                totalIntelligence += set.getValue().getArmor_attribute().getIntelligence();
            }
        }
        return new HeroAttribute(totalStrength, totalDexterity, totalIntelligence);

    }

    /**
     * Method for showing the heroes state
     * @return a string value containing the heroes Name, class, level, total strength, total dexterity total intelligence and damage
     */

    public abstract String display();



}
