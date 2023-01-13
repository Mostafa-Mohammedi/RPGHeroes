package no.noroff.heroes.Equip;

public abstract class Items {
    String name;
    int RequiredLevel;
    Slot slot;

    // constructor

    public Items(String name, int requiredLevel, Slot slot) {
        this.name = name;
        RequiredLevel = requiredLevel;
        this.slot = slot;
    }


    // method

    public abstract  void required_hero_item ();
}
