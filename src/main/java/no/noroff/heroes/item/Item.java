package no.noroff.heroes.item;

import no.noroff.heroes.equipment.Slot;

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

}
