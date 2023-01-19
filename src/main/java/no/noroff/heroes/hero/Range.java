package no.noroff.heroes.hero;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;

/**
 * Range class is used for creating a Range hero
 */
public class Range extends Hero {

    private final String warrior_name;
    private final double warrior_level;

    final private double strength;
    final private double dexterity;
    final private double intelligence;


    private double total_range_attribute;
    private double total_range_damage;


    /**
     * Constructor for creating an instance of the range hero
     * @param name value String
     */
    public Range(String name) {
        super(name);

        // level and name
        warrior_level = level = 1;
        warrior_name = name;

        // level
        levelAttribute.setStrength(1);
        levelAttribute.setDexterity(7);
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
        valid_Weapon_type.add(Weapon_type.BOWS);

        // valid armor type
        Valid_Armor_type.add(Armor_type.LEATHER);
        Valid_Armor_type.add(Armor_type.MAIL);
    }

    @Override
    public void damage() {
        if (weapon_damage == 0) {
            weapon_damage = 1;
        }
        total_range_damage = weapon_damage * (1+ (levelAttribute.getDexterity()/100));
        System.out.println("total damage: " + total_range_damage);
    }



    /**
     * Calculate total damage dealt to opponent
     * includes equip weapon attribute
     * the completed damage is calculated in the total_warrior_damage variable
     */

    @Override
    public double totalAttributes() {
        total_range_attribute = (
                levelAttribute.getStrength() +
                levelAttribute.getDexterity() +
                levelAttribute.getIntelligence()) +
                armor_attribute;
        return total_range_attribute;
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
