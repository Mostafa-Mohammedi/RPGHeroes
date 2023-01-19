package no.noroff.heroes.CustomException;

/**
 * Custom exception class for hero if he wants to equip a weapon that he cannot use
 */
public class InvalidWeaponType extends Exception {

    /**
     * custom exception informing hero that he cannot use the weapon type
     * @param weapon String value of weapon
     * @param hero String value of hero
     */
    public InvalidWeaponType(String weapon, String hero) {
        super(weapon + " cannot be used for " + hero);
    }

}
