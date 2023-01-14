package no.noroff.heroes;

import no.noroff.heroes.Slot;

public abstract class Item {
    String name;
    int RequiredLevel;
    Slot slot;



    // constructor

    public Item(String name, int requiredLevel) {
        this.name = name;
        RequiredLevel = requiredLevel;
    }


    // method

    /**
     * method for checking the required level for hero item
     */
    public abstract  void item_level (int requiredLevel);
}
