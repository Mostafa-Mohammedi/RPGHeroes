package no.noroff.heroes.hero;

public abstract class HeroAttribute {
    private double strength;
    private double dexterity;
    private double intelligence;

    // constructor

    public HeroAttribute(double strength, double dexterity, double intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    // method

    public abstract void total_level_attribute(HeroAttribute attribute);

    //getter and setter
    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getDexterity() {
        return dexterity;
    }

    public void setDexterity(double dexterity) {
        this.dexterity = dexterity;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }


}
