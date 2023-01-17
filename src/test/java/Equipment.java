import no.noroff.heroes.CustomException.InvalidArmorType;
import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.HeroAttribute;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.hero.Warrior;
import no.noroff.heroes.item.Armor;
import no.noroff.heroes.item.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Equipment {
    @Test
    void equip_warrior_weapon() throws InvalidLevel, InvalidWeaponType {

        // Arrange
        var sword  = new Weapon("legendary sword",
                1,
                Slot.WEAPON,
                1,
                Weapon_type.SWORDS);

        var warrior = new Warrior("Djengis Khan");

        // Act
        String actual = warrior.equip_weapon(sword);

        // Assert
        String expected = warrior.getName() + " has been equip with " + sword.get_weapon_name();

        assertEquals(expected, actual);


    }


    @Test
    void equip_warrior_weapon_check_invalid_weapon_type() throws InvalidLevel, InvalidWeaponType {
        // Arrange
        var staff = new Weapon("begynner staff",
                1,
                Slot.WEAPON,
                1,
                Weapon_type.STAFF);


        var warrior = new Warrior("Djengis Khan");

        // Act

        Exception exception = assertThrows(InvalidWeaponType.class, () -> {
            warrior.equip_weapon(staff);
        });
        String actual = exception.getMessage();

        // Assert
        String expected = staff.getWeaponType().name().toLowerCase() + " cannot be used for " + warrior.getClass().getSimpleName();

        assertEquals(expected, actual);
    }


    @Test
    void equip_warrior_weapon_check_InvalidLevel() throws InvalidLevel, InvalidWeaponType {

        // Arrange
        var sword = new Weapon("legendary sword",
                3,
                Slot.WEAPON,
                1,
                Weapon_type.SWORDS);

        var warrior = new Warrior("Djengis Khan");

        // Act

        Exception exception = assertThrows(InvalidLevel.class, () -> {
            warrior.equip_weapon(sword);
        });
        String actual = exception.getMessage();

        // Assert

        String expected = warrior.getName() + " level is to low please use another weapon.";

        assertEquals(expected, actual);

    }


    @Test
    void equip_warrior_armor() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Arrange

        var mail = new Armor("beginner armor",
                1,
                Slot.BODY,
                Armor_type.MAIL,
                new HeroAttribute(1,0,0));

        // Act
        var warrior = new Warrior("Djengis khan");
        String expected = warrior.equip_armor(mail);

        // Assert
        String actual = "equipment: " + mail.getArmorType().name().toLowerCase() + " has been added to "+ warrior.getName();

        assertEquals(expected, actual);

    }

    @Test
    void equip_warrior_armor_check_invalid_armor_level() throws InvalidLevel, InvalidArmorType {

        // Arrange
        var staff = new Armor("begynner armor",
                2,
                Slot.BODY,
                Armor_type.PLATE,
                new HeroAttribute(1,0,0));



        var warrior = new Warrior("Djengis Khan");

        // Act

        Exception exception  = assertThrows(InvalidLevel.class, () -> {
            warrior.equip_armor(staff);
        });
        String actual = exception.getMessage();

        // Assert
        String expected = warrior.getWarrior_name() + " level is to low please use another weapon.";

        assertEquals(expected, actual);


    }

    @Test
    void equip_warrior_armor_check_Invalid_armor_type() throws InvalidLevel, InvalidArmorType {

        // Arrange

        var cloth = new Armor("begyner armor",
                2,
                Slot.BODY,
                Armor_type.CLOTH,
                new HeroAttribute(1,0,0));

        var warrior = new Warrior("Djengis Khan");

        // Act
        String actual = "cloth cannot be used for Warrior hero ";

        Exception exception = assertThrows(InvalidArmorType.class, () -> {
            warrior.equip_armor(cloth);
        });
        String expected = exception.getMessage();

        assertEquals(expected, actual);

    }

    @Test
    void equip_warrior_one_armor() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Arrange

        var mail = new Armor("beginner armor",
                1,
                Slot.BODY,
                Armor_type.MAIL,
                new HeroAttribute(1,0,0));


        // Act
        var warrior = new Warrior("Djengis khan");
        warrior.equip_armor(mail);

        double expected = warrior.totalAttributes();

        // Assert
        double actual = 9;

        assertEquals(expected, actual);
    }

    @Test
    void equip_warrior_Two_armor() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Arrange

        var mail = new Armor("beginner armor",
                1,
                Slot.BODY,
                Armor_type.MAIL,
                new HeroAttribute(1,0,0));

        var plate = new Armor("beginner armor",
                1,
                Slot.BODY,
                Armor_type.PLATE,
                new HeroAttribute(1,0,0));

        // Act
        var warrior = new Warrior("Djengis khan");
       warrior.equip_armor(mail);
        warrior.equip_armor(plate);

        double expected = warrior.totalAttributes();

        // Assert
        double actual = 10;

        assertEquals(expected, actual);
    }

    @Test
    void change_armor_check_total_attribute() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Arrange

        var mail = new Armor("beginner armor",
                1,
                Slot.BODY,
                Armor_type.MAIL,
                new HeroAttribute(1,0,0));

        var plate = new Armor("beginner armor",
                1,
                Slot.BODY,
                Armor_type.PLATE,
                new HeroAttribute(1,0,0));

        // Act
        var warrior = new Warrior("Djengis khan");
        warrior.equip_armor(mail);
        warrior.remove_armor(mail);
        warrior.equip_armor(plate);

        double expected = warrior.totalAttributes();

        // Assert
        double actual = 9;
        assertEquals(expected, actual);
    }



}
