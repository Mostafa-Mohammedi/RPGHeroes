package no.noroff.heroes.CustomException;

public class InvalidLevel extends Exception{

    public InvalidLevel(String hero) {
        super(hero + " level is to low please use another weapon.");
    }
}
