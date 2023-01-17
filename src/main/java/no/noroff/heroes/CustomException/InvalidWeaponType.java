package no.noroff.heroes.CustomException;

public class InvalidWeaponType extends Exception {

    public InvalidWeaponType() {
    }

    public InvalidWeaponType(String weapon, String hero) {
        super(weapon + " cannot be used for " + hero);
    }

}
