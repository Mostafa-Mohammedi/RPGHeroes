package no.noroff.heroes.Equip.item;

import no.noroff.heroes.Equip.Items;
import no.noroff.heroes.Equip.Slot;

public class Weapon extends Items {


    public Weapon(String name, int requiredLevel, Slot slot) {
        super(name, requiredLevel, slot);
    }

    @Override
    public void required_hero_item() {

    }
}
