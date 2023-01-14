package no.noroff.heroes.item;

import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.HeroAttribute;
import no.noroff.heroes.Item;

public class Armor extends Item {

    Armor_type armorType;
    HeroAttribute armorAttribute;

    public Armor(String name, int requiredLevel, Armor_type armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    @Override
    public void item_level(int requiredLevel) {

    }
}
