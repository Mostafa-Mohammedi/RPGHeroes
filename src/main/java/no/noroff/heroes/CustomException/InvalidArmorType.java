package no.noroff.heroes.CustomException;

public class InvalidArmorType extends Exception{

    public InvalidArmorType(String armor) {
        super(armor);
    }
}
