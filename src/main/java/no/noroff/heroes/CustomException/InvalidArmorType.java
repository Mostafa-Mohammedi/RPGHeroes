package no.noroff.heroes.CustomException;

public class InvalidArmorType extends Exception{

    /**
     * custom exception for checking that the hero cannot equip wrong type of armor
     * @param armor throw a string custom exception telling the hero that he cannot use the type of armor
     */
    public InvalidArmorType(String armor) {
        super(armor);
    }
}
