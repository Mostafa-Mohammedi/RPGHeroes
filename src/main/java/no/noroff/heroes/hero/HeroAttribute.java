package no.noroff.heroes.hero;

/**
 * Hero attribute class is used for adding the initial hero attribute
 * @author Mostafa Mohammedi
 */
public class HeroAttribute {
    private double strength;
    private double dexterity;
    private double intelligence;

    /**
     * empty  hero constructor
     */
    public HeroAttribute() {
    }


    /**
     * Constructor for creating the hero attribute
     * @param strength double value for giving hero strength
     * @param dexterity double value for dexterity
     * @param intelligence double value for intelligence
     */
    public HeroAttribute(double strength, double dexterity, double intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }


    /**
     * Getter for getting the hero strength
     * @return streng value double
     */
    public double getStrength() {
        return strength;
    }

    /**
     * Setter for setting the initial hero strength
     * @param strength strength value double
     */
    public void setStrength(double strength) {
        this.strength = strength;
    }

    /**
     * getter for getting the dexterity value of the hero
     * @return dexterity value double
     */
    public double getDexterity() {
        return dexterity;
    }

    /**
     * setter for setting the hero dexterity at initialization
     * @param dexterity value double
     */
    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * getter for getting the intelligence of the hero
     * @return intelligence hero double
     */
    public double getIntelligence() {
        return intelligence;
    }

    /**
     * setter for setting the hero inteligence at initialization
     * @param intelligence  value double
     */
    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }


}
