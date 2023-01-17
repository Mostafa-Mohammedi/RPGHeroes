package no.noroff.heroes;

public class HeroAttribute {
    private double strength;
    private double dexterity;
    private double intelligence;


    // constructor


    public HeroAttribute() {
    }

    public HeroAttribute(double strength, double dexterity, double intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    // method

    public void total_level_attribute(String choice, double increase_strength){
        if(choice.equalsIgnoreCase("strength")){
            strength += increase_strength;
        }
        else if(choice.equalsIgnoreCase("dexterity")){
            dexterity += increase_strength;
        }
        else if(choice.equalsIgnoreCase("intelligence")){
            intelligence += increase_strength;
        }


    }
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
