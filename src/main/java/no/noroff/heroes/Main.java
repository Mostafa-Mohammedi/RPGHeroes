package no.noroff.heroes;

import no.noroff.heroes.CustomException.InvalidArmorType;
import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.hero.Warrior;

public class Main {
    public static void main(String[] args) {


        Warrior mosti = new Warrior("mosti");
        try {
            mosti.equip_weapon("test sword", "swords", 1);
        } catch (InvalidLevel e) {
            throw new RuntimeException(e);
        } catch (InvalidWeaponType e) {
            throw new RuntimeException(e);
        }


        try {
            mosti.equip_armor("MAIL", 1);
        } catch (InvalidArmorType e) {
            throw new RuntimeException(e);
        }

        /*
        mosti.totalAttributes();
        mosti.levelUp(3);
        mosti.damage();
        System.out.println(mosti.display());

        System.out.println(mosti);
        */
    }
}