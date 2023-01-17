import no.noroff.heroes.CustomException.InvalidArmorType;
import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.hero.HeroAttribute;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.hero.Warrior;
import no.noroff.heroes.item.Armor;
import no.noroff.heroes.item.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Test_Hero {
    private Warrior warrior;

    @BeforeEach
    void init(){
        // Arrange
        warrior = new Warrior("Djengis Khan");

    }


    @Test
    void Hero__level_increase_new_level(){

        //Arrange


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
        int warrior_levelIncrease = 1;

        double  warrior_strength_increase_each_level = 3;
        double warrior_dexterity_increase_each_level = 2;
        double warrior_intelligence_increase_each_level = 1 ;


        // Act
        warrior.levelUp(warrior_levelIncrease, warrior_strength_increase_each_level, warrior_dexterity_increase_each_level, warrior_intelligence_increase_each_level);
        double actual = warrior.getTotal_intelligence_increase();

        // Assert
        int expected = (int) (warrior.getLevelAttribute().getIntelligence());
        assertEquals(expected, actual);

    }

    @Test
    void calculate_hero_damage_with_no_equipment(){

        // Arrange
        warrior.damage();
        // Act
        double actual = warrior.get_total_warrior_damage();

        // Assert

        double weaponDamage = 1;
        double strength = warrior.getLevelAttribute().getStrength();
        double expected = weaponDamage *(1 + (strength/100));
        assertEquals(expected, actual);

    }

    @Test
    void test_hero_damage_with_none_armor() throws InvalidLevel, InvalidWeaponType {
        // Arrange
        warrior.damage();

        // Act
        double actual = warrior.get_total_warrior_damage();

        // Assert
        int weaponDamage = 1;
        double strength = warrior.getLevelAttribute().getStrength();
        double expected =  weaponDamage * (1 + ((strength)/ 100));
        assertEquals(expected, actual);

    }


    @Test
    void test_hero_damage_with_one_armor() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Arrange
        Armor plate = new Armor("Armor", 1, Slot.BODY, Armor_type.PLATE, new HeroAttribute(1,0,0));

        warrior.equip_armor(plate);
        warrior.damage();
        // Act
        double actual = warrior.get_total_warrior_damage();

        // Assert

        int weaponDamage = 1;
        double strength = warrior.getLevelAttribute().getStrength();
        double expected =  weaponDamage * (1 + ((strength)/ 100));
        assertEquals(expected, actual);

    }


    @Test
    void test_hero_damage_with_two_armor() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Arrange
        Armor plate = new Armor("Armor", 1, Slot.BODY, Armor_type.PLATE, new HeroAttribute(1,0,0));
        warrior.remove_armor(plate);
        Armor mail = new Armor("Armor", 1, Slot.BODY, Armor_type.MAIL, new HeroAttribute(5,0,0));

        warrior.equip_armor(plate);
        warrior.equip_armor(mail);

        warrior.damage();

        // Act
        double actual = warrior.get_total_warrior_damage();

        // Assert
        int weaponDamage = 5;
        double strength = warrior.getLevelAttribute().getStrength();
        double expected =  weaponDamage * (1 + ((strength)/ 100));
        assertEquals(expected, actual);

    }



    @Test
     void test_hero_damage_with_one_weapon() throws InvalidLevel, InvalidWeaponType {

        // Arrange
        Weapon sword = new Weapon("Sword", 1, Slot.WEAPON, 1, Weapon_type.SWORDS);

        warrior.equip_weapon(sword);
        warrior.damage();
        // Act
        double actual = warrior.get_total_warrior_damage();

        // Assert

        int weaponDamage = 1;
        double strength = warrior.getLevelAttribute().getStrength();
        double expected =  weaponDamage * (1 + ((strength)/ 100));
        assertEquals(expected, actual);
    }

    @Test
    void test_hero_damage_with_replaced_weapon() throws InvalidLevel, InvalidWeaponType {

        // Arrange
        warrior.equip_weapon(new Weapon("Golden Hammer", 1, Slot.WEAPON, 5, Weapon_type.HAMMERS));

        warrior.equip_weapon(new Weapon("Golden HAxe", 1, Slot.WEAPON, 10, Weapon_type.AXES));

        warrior.damage();

        // Act
        double actual = 10.5;

        // Assert

        int weaponDamage = 10;
        double strength = warrior.getLevelAttribute().getStrength();
        double expected = weaponDamage *(1 + (strength/100));
        assertEquals(expected, actual);

    }


    @Test
    void test_hero_damage_with_one_weapon_armor_weapon() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Arrange
        warrior.equip_weapon(new Weapon("Golden Hammer", 1, Slot.WEAPON, 5, Weapon_type.HAMMERS));

        warrior.equip_armor(new Armor("Plate", 1, Slot.BODY, Armor_type.PLATE, new HeroAttribute(10, 0,0)));
        // Act
        warrior.damage();

        double actual = warrior.get_total_warrior_damage();
        // Assert

        int weaponDamage = 15;
        double strength = warrior.getLevelAttribute().getStrength();
        double expected = weaponDamage *(1 + (strength/100));
        assertEquals(expected, actual);

    }

    @Test
    void Check_hero_display_state(){

        // Arrange
        // Act
        String actual = warrior.display();

        // Assert

        String expected = "name: " + warrior.getName() +
                " class: " +
                warrior.getClass().getSimpleName() +
                " level: " + warrior.getLevel() +
                " strength: " +  warrior.getLevelAttribute().getStrength() +
                " dexterity: " + warrior.getLevelAttribute().getDexterity() +
                " intelligence: " + warrior.getLevelAttribute().getIntelligence() +
                " Damage " + warrior.get_total_warrior_damage();

        assertEquals(expected, actual);

    }


}