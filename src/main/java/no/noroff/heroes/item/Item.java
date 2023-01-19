package no.noroff.heroes.item;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.hero.HeroAttribute;


/**
 * Item class is an abstract class tha contains the shared values of the weapon type
 */
public abstract class Item {
    protected String name;
    protected int RequiredLevel;
    protected Slot slot;
    protected int weapon_damage;
    protected Armor_type armor_type;
    protected HeroAttribute armor_attribute;
    protected Weapon_type weapon_type;


    /**
     * Constructor for initializing the other classes that extends the item class
     * @param name The name of the item that we want to create string value
     * @param requiredLevel The level of the item that the hero is required to be for equipping the hero
     * @param slot The place on the hero where the item is going to be used enum value
     */
    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        RequiredLevel = requiredLevel;
        this.slot = slot;
        this.weapon_type = null;
        weapon_damage = 0;
        armor_attribute = null;
        armor_type = null;
    }

    /**
     * Getter for getting the weapon name String value
     * @return weapon name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for getting the weapon level
     * @return weapon level int value
     */

    public int getRequiredLevel() {
        return RequiredLevel;
    }

    /**
     * Getter for getting the weapon type
     * @return weapon type enum value
     */

    public Weapon_type getWeapon_type() {
        return weapon_type;
    }

    /**
     * Getter for getting the weapon damage
     * @return weapon damage int value
     */
    public int getWeapon_damage() {
        return weapon_damage;
    }

    /**
     * Getter for getting the armor type
     * @return armor type enum value
     */
    public Armor_type getArmor_type() {
        return armor_type;
    }

    /**
     * getter for getting the hero attribute
     * @return an instance of the hero attribute
     */

    public HeroAttribute getArmor_attribute() {
        return armor_attribute;
    }

    /**
     * Getter for getting slot of the item for equipping
     * @return slot enum value
     */
    public Slot getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", RequiredLevel=" + RequiredLevel +
                ", slot=" + slot +
                ", weapon_damage=" + weapon_damage +
                ", armor_type=" + armor_type +
                ", armor_attribute=" + armor_attribute +
                ", weapon_type=" + weapon_type +
                '}';
    }
}
