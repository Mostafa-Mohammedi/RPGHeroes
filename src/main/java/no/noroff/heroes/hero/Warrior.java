package no.noroff.heroes.hero;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;

public class Warrior extends Hero{

    double total_warrior_attribute = 0;


    //constructor
    public Warrior(String name) {
        super(name);

        // level

        levelAttribute.setStrength(5);
        levelAttribute.setDexterity(2);
        levelAttribute.setIntelligence(1);

        // slot item
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.LEGS, null);

        // valid weapon type
        valid_Weapon_type.add(Weapon_type.AXES.name());
        valid_Weapon_type.add(Weapon_type.HAMMERS.name());
        valid_Weapon_type.add(Weapon_type.SWORDS.name());

        // valid armor type
        Valid_Armor_type.add(Armor_type.MAIL.name());
        Valid_Armor_type.add(Armor_type.PLATE.name());

    }


    // method
    @Override
    public void levelUp(double level_increase) {

    }

    @Override
    public void damage() {

    }

    @Override
    public String equip_armor(String armor_type, double armor_level) throws InvalidWeaponType {

        armor_attribute = armor_level;

        for (String armor : Valid_Armor_type) {

            if(armor.toUpperCase().equals(armor_type) && armor_level == level){
                System.out.println("equipment: " + armor_type + " has been added to warrior");
                return "equipment: " + armor_type + " has been added to warrior";
            }
        }

        throw new InvalidWeaponType( armor_type + " cannot be used for Warrior");
    }


    @Override
    public String equip_weapon(String weapon_type, double weapon_level) throws InvalidWeaponType {
        weapon_attribute += weapon_level;

        for (String weapon : valid_Weapon_type) {

            if(weapon.toUpperCase().equals(weapon_type) && weapon_level == level){
                System.out.println("equipment: " + weapon_type + " has been added to warrior");
                return "equipment: " + weapon_type + " has been added to warrior";
            }
        }
        throw new InvalidWeaponType(weapon_type + " cannot be used for Warrior");
    }


    @Override
    public void totalAttributes() {

        total_warrior_attribute = (levelAttribute.getStrength() + levelAttribute.getDexterity() + levelAttribute.getIntelligence()) +  (weapon_attribute + armor_attribute);




    }

    @Override
    public void display() {

    }

    @Override
    public String toString() {
        return  "Hero type " + name +
                " level " + levelAttribute.getStrength() +
                " dexterity " +  levelAttribute.getDexterity() +
                " intelligence " + levelAttribute.getIntelligence() +
                " weapon " + equipment +
                " weapon type " + valid_Weapon_type +
                "total attribute " + total_warrior_attribute;
    }
}
