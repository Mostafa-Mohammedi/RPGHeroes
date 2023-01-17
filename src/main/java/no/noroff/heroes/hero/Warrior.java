package no.noroff.heroes.hero;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;


public class Warrior extends Hero {
    private final String warrior_name;

    private final double warrior_level;

    final private double strength;
    final private double dexterity;
    final private double intelligence;

    private double total_warrior_attribute;
    private double total_warrior_damage;


    //constructor
    public Warrior(String name) {
        super(name);

        // level and name
        warrior_level = level = 1;
        warrior_name = name;
        // attribute

        levelAttribute.setStrength(5);
        levelAttribute.setDexterity(2);
        levelAttribute.setIntelligence(1);

        // get initial strength
        strength = levelAttribute.getStrength();
        dexterity = levelAttribute.getDexterity();
        intelligence = levelAttribute.getIntelligence();

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


    //getter setter

    public String getWarrior_name() {
        return warrior_name;
    }


    @Override
    public void damage() {
        if(weapon_damage == 0){
            weapon_damage = 1;
        }
        total_warrior_damage = weapon_damage *
                (1 + (levelAttribute.getStrength() / 100));

    }


    public double getTotal_warrior_damage() {
        return total_warrior_damage;
    }

    // method

    /**
     * Calculate total damage dealt to opponent
     * includes equip weapon attribute
     * the completed damage is calculated in the total_warrior_damage variable
     */

    @Override
    public double totalAttributes() {

        total_warrior_attribute = (levelAttribute.getStrength() +
                                    levelAttribute.getDexterity() +
                                    levelAttribute.getIntelligence()) +
                                    armor_attribute;
        return total_warrior_attribute;


    }

    @Override
    public String display() {
        if(total_warrior_damage == 0){
            total_warrior_damage = 1;
        }
        return "name: " + name +
                " class: " + this.getClass().getSimpleName() +
                " level: " + level +
                " strength: " +  levelAttribute.getStrength() +
                " dexterity: " +levelAttribute.getDexterity() +
                " intelligence: " + levelAttribute.getIntelligence() +
                " Damage " + total_warrior_damage;
    }


}
