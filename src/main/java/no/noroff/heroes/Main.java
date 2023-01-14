package no.noroff.heroes;

import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.hero.Warrior;

public class Main {
    public static void main(String[] args) {

        //Armor armor = new Armor("plate", 1, Armor_type.LEATHER, new HeroAttribute());


        Warrior mosti = new Warrior("mosti");
        try {
            mosti.equip_weapon("SWORDS", 1);
        } catch (InvalidWeaponType e) {
            throw new RuntimeException(e);
        }

        try {
            mosti.equip_armor("MAIL", 1);
        } catch (InvalidWeaponType e) {
            throw new RuntimeException(e);
        }

        mosti.totalAttributes();
        mosti.damage();

        System.out.println(mosti);

    }
}