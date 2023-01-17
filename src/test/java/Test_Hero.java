import no.noroff.heroes.CustomException.InvalidArmorType;
import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.HeroAttribute;
import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.hero.Hero;
import no.noroff.heroes.hero.Warrior;
import no.noroff.heroes.item.Armor;
import no.noroff.heroes.item.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Test_Hero {


    @Test
    void Hero__level_increase_new_level(){

        //Arrange

        Hero warrior = new Warrior("Djengis Khan");

        int warrior_level = 1;
        int warrior_levelIncrease = 2;

        double  warrior_strength_increase_each_level = 3;
        double warrior_dexterity_increase_each_level = 2;
        double warrior_intelligence_increase_each_level = 1 ;

        // Act
        int  actual = warrior.levelUp(warrior_levelIncrease, warrior_strength_increase_each_level, warrior_dexterity_increase_each_level, warrior_intelligence_increase_each_level);

        // Assert
        int expected = warrior_level + warrior_levelIncrease;
        assertEquals(expected, actual);
    }

    @Test
    void Hero_strength_increase_each_level(){

        //Arrange

        Hero warrior = new Warrior("Djengis Khan");

        int warrior_levelIncrease = 2;

        double  warrior_strength_increase_each_level = 3;
        double warrior_dexterity_increase_each_level = 2;
        double warrior_intelligence_increase_each_level = 1 ;


        // Act
        warrior.levelUp(warrior_levelIncrease, warrior_strength_increase_each_level, warrior_dexterity_increase_each_level, warrior_intelligence_increase_each_level);
        double actual = warrior.getTotal_strength_Increase();

        // Assert
        int expected = (int) (warrior.getLevelAttribute().getStrength());
        assertEquals(expected, actual);


    }

    @Test
    void Hero_dexterity_increase_each_level(){

        //Arrange

        Hero warrior = new Warrior("Djengis Khan");

        int warrior_levelIncrease = 1;

        double  warrior_strength_increase_each_level = 3;
        double warrior_dexterity_increase_each_level = 2;
        double warrior_intelligence_increase_each_level = 1 ;


        // Act
        warrior.levelUp(warrior_levelIncrease, warrior_strength_increase_each_level, warrior_dexterity_increase_each_level, warrior_intelligence_increase_each_level);
        double actual = warrior.getTotal_dexterity_Increase();

        // Assert
        int expected = (int) (warrior.getLevelAttribute().getDexterity());
        assertEquals(expected, actual);

    }

    @Test
    void Hero_intelligence_increase_each_level(){

        //Arrange

        Hero warrior = new Warrior("Djengis Khan");

        int warrior_levelIncrease = 1;

        double  warrior_strength_increase_each_level = 3;
        double warrior_dexterity_increase_each_level = 2;
        double warrior_intelligence_increase_each_level = 1 ;


        // Act
        warrior.levelUp(warrior_levelIncrease, warrior_strength_increase_each_level, warrior_dexterity_increase_each_level, warrior_intelligence_increase_each_level);
        double actual = warrior.getTotal_intelligence_Increase();

        // Assert
        int expected = (int) (warrior.getLevelAttribute().getIntelligence());
        assertEquals(expected, actual);

    }




}