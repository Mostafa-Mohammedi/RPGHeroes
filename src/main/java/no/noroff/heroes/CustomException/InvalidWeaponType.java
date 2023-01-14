package no.noroff.heroes.CustomException;

public class InvalidWeaponType extends Exception {

    public InvalidWeaponType(String message) {
        super(message);
    }
}
