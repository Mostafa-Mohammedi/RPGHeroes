package no.noroff.heroes.item;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Weapon_type;


/**
 * weapon class is used for equipping the hero with a weapon
 */
public class Weapon extends Item {

    private int weaponDamage;
    private Weapon_type weaponType;


    /**
     * Constructor for creating an instance of the weapon for equipping the hero
     * @param name the weapon name of the hero string value
     * @param requiredLevel the weapon level of the hero int value
     * @param slot Enum for initializing the weapon belong on the hero
     * @param weaponDamage Weapon damage when equip on the hero
     * @param weaponType Enum containing all weapon that a hero can use
     */
    public Weapon(String name, int requiredLevel, Slot slot, int weaponDamage, Weapon_type weaponType) {
        super(name, requiredLevel, slot);
        this.weaponDamage = weaponDamage;
        this.weaponType = weaponType;
        weapon_type = weaponType;
        weapon_damage = weaponDamage;
    }

    /**
     * Getter for getting the weapon damage
     * @return  weapon damage int value
     */
    public int getWeaponDamage() {
        return weaponDamage;
    }

    /**
     * Getter for getting the enum weapon type
     * @return  weapon type enum value
     */
    public Weapon_type getWeaponType() {
        return weaponType;
    }


}
