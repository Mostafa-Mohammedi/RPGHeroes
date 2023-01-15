package no.noroff.heroes;

import no.noroff.heroes.Slot;

public abstract class Item {
    protected String name;
    protected int RequiredLevel;
    protected Slot slot;



    // constructor

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        RequiredLevel = requiredLevel;
        this.slot = slot;
    }


    // method

    /**
     * method for checking the required level for hero item
     */
    public abstract  void item_level (int requiredLevel);
}
