package no.noroff.heroes.hero;

import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;

public class Range extends Hero {

    final private int strength_increase_each_level = 1;
    final private int dexterity_increase_each_level = 5;
    final private int intelligence_increase_each_level = 1;

    private double total_range_attribute;
    private double total_range_damage;


    public Range(String name) {
        super(name);

        // level

        levelAttribute.setStrength(1);
        levelAttribute.setDexterity(7);
        levelAttribute.setIntelligence(1);

        // slot item
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.LEGS, null);

        // valid weapon type
        valid_Weapon_type.add(Weapon_type.BOWS.name());

        // valid armor type
        Valid_Armor_type.add(Armor_type.LEATHER.name());
        Valid_Armor_type.add(Armor_type.MAIL.name());


    }

    @Override
    public void levelUp(double level_increase) {

        double total_strength_Increase = (level_increase * strength_increase_each_level) + levelAttribute.getStrength();
        double total_dexterity_Increase = (level_increase * dexterity_increase_each_level) + levelAttribute.getDexterity();
        double total_intelligence_Increase = (level_increase * intelligence_increase_each_level) + levelAttribute.getIntelligence();

        levelAttribute.setStrength(total_strength_Increase) ;
        levelAttribute.setDexterity(total_dexterity_Increase);
        levelAttribute.setIntelligence(total_intelligence_Increase);

        level += level_increase;
        System.out.println("total level increase: " + total_strength_Increase);

    }

    @Override
    public void damage() {
        total_range_damage = WeaponDamage * (1+ (levelAttribute.getStrength()/100));
        System.out.println("total damage: " + total_range_attribute);

    }

    @Override
    public String equip_armor(String armor_type, double armor_level) throws InvalidWeaponType {
        armor_attribute = armor_level;

        for (String armor : Valid_Armor_type) {

            if(armor.toUpperCase().equals(armor_type) && armor_level == level){

                return "equipment: " + armor_type + " has been added to " + name;
            }
        }

        throw new InvalidWeaponType( armor_type + " cannot be used for " + this.getClass().getSimpleName() + " hero ");
    }


    @Override
    public String equip_weapon(String weapon_type, double weapon_level) throws InvalidWeaponType {
        //WeaponDamage += weapon_level;

        for (String weapon : valid_Weapon_type) {

            if(weapon.toUpperCase().equals(weapon_type) && weapon_level == level){
                System.out.println("equipment: " + weapon_type + " has been added to " + name);
                return "equipment: " + weapon_type + " has been added to " + name;
            }
        }
        throw new InvalidWeaponType(weapon_type + " cannot be used for " + name);
    }

    @Override
    public void totalAttributes() {
        total_range_attribute = (levelAttribute.getStrength() +
                levelAttribute.getDexterity() +
                levelAttribute.getIntelligence()) +
                (WeaponDamage + armor_attribute);

    }

    @Override
    public String display() {
        return "name: " + name +
                " class: " + this.getClass().getSimpleName() +
                " level: " + level +
                " strength: " +  levelAttribute.getStrength() +
                " dexterity: " +levelAttribute.getDexterity() +
                " intelligence: " + levelAttribute.getIntelligence() +
                " Damage " + total_range_damage;
    }
}