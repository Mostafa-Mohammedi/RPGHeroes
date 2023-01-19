package no.noroff.heroes.hero;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;

/**
 * Mage class is used to initialize a mage hero
 * @author Mostafa Mohammedi
 */
public class Mage extends Hero{
    private final String warrior_name;
    private final double warrior_level;

    final private double strength;
    final private double dexterity;
    final private double intelligence;


    private double total_mage_attribute;
    private double total_mage_damage;

    /**
     * Constructor of the mage class
     * @param name value string
     */
    public Mage(String name) {
        super(name);
        // level and name
        warrior_level = level = 1;
        warrior_name = name;
        // attribute

        levelAttribute.setStrength(1);
        levelAttribute.setDexterity(1);
        levelAttribute.setIntelligence(8);

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
        valid_Weapon_type.add(Weapon_type.STAFF);
        valid_Weapon_type.add(Weapon_type.WANDS);

        // valid armor type
        Valid_Armor_type.add(Armor_type.CLOTH);

    }

    @Override
    public void damage() {
        if (weapon_damage == 0) {
            weapon_damage = 1;
        }
        total_weapon_Damage = weapon_damage *
                (1+ (levelAttribute.getIntelligence()/100));

    }


    @Override
    public String display() {
        return "name: " + name +
                " class: " + this.getClass().getSimpleName() +
                " level: " + level +
                " strength: " +  levelAttribute.getStrength() +
                " dexterity: " +levelAttribute.getDexterity() +
                " intelligence: " + levelAttribute.getIntelligence() +
                " Damage " + total_mage_damage;
    }
}
