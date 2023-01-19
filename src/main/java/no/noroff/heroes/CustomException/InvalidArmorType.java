package no.noroff.heroes.CustomException;


/**
 * custom exception class for hero if he wants to equip the wrong armor type
 */
public class InvalidArmorType extends Exception{

    /**
     * custom exception for checking if hero tries to equip a weapon that he cannot equip
     * @param armor throw a string custom exception telling the hero that he cannot use the type of armor
     */
    public InvalidArmorType(String armor) {
        super(armor);
    }
}
