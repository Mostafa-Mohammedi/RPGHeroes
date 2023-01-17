package no.noroff.heroes.CustomException;

public class InvalidLevel extends Exception{

    /**
     * custom exception warning that the weapon level is too high so that he cannot use the weapon.
     * @param hero throwing a string message telling the hero his level is too low
     */
    public InvalidLevel(String hero) {
        super(hero + " level is to low please use another weapon.");
    }
}
