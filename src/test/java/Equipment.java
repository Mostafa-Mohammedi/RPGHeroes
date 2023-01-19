import no.noroff.heroes.CustomException.InvalidArmorType;
import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.hero.HeroAttribute;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.hero.Warrior;
import no.noroff.heroes.item.Armor;
import no.noroff.heroes.item.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Equipment {

    private Warrior warrior;
    private Weapon sword;
    private Weapon staff;

    private Armor mail;
    private Armor plate;

    private Weapon invalid_level_sword;
    private Armor invalid_type_cloth;

    private Armor invalid_level_plate;

    @BeforeEach
    void init(){
        // Arrange

        warrior = new Warrior("Djengis Khan");

         sword  = new Weapon("legendary sword",
                1,
                Slot.WEAPON,
                1,
                Weapon_type.SWORDS);

         staff = new Weapon("begynner staff",
                1,
                Slot.WEAPON,
                1,
                Weapon_type.STAFF);

        mail = new Armor("beginner armor",
                1,
                Slot.BODY,
                Armor_type.MAIL,
                new HeroAttribute(1,0,0));


        plate = new Armor("beginner armor",
                1,
                Slot.BODY,
                Armor_type.PLATE,
                new HeroAttribute(1,0,0));

        invalid_level_sword = new Weapon("legendary sword",
                2,
                Slot.WEAPON,
                1,
                Weapon_type.SWORDS);


        invalid_level_plate = new Armor("beginner armor",
                2,
                Slot.BODY,
                Armor_type.PLATE,
                new HeroAttribute(1,0,0));

        invalid_type_cloth = new Armor("beginner armor",
                2,
                Slot.BODY,
                Armor_type.CLOTH,
                new HeroAttribute(1,0,0));

    }
    @Test
    void equip_warrior_weapon() throws InvalidLevel, InvalidWeaponType {

        // Arrange
        String actual = warrior.equip_weapon(sword);

        // Assert
        String expected = warrior.getName() + " has been equip with " + sword.getName();

        assertEquals(expected, actual);


    }
    @Test
    void equip_warrior_weapon_check_invalid_weapon_type() throws InvalidLevel, InvalidWeaponType {

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
    void equip_warrior_weapon_check_Invalid_Level() throws InvalidLevel, InvalidWeaponType {

        // Act

        Exception exception = assertThrows(InvalidLevel.class, () -> {
            warrior.equip_weapon(invalid_level_sword);
        });
        String actual = exception.getMessage();

        // Assert

        String expected = warrior.getName() + " level is to low please use another weapon.";

        assertEquals(expected, actual);

    }

    @Test
    void equip_warrior_armor() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Act
        String expected = warrior.equip_armor(mail);

        // Assert
        String actual = "equipment: " + mail.getArmorType().name().toLowerCase() + " has been added to "+ warrior.getName();

        assertEquals(expected, actual);

    }

    @Test
    void equip_warrior_armor_check_invalid_armor_level() throws InvalidLevel, InvalidArmorType {

        // Act
        Exception exception  = assertThrows(InvalidLevel.class, () -> {
            warrior.equip_armor(invalid_level_plate);
        });
        String actual = exception.getMessage();

        // Assert
        String expected = warrior.getName() + " level is to low please use another weapon.";

        assertEquals(expected, actual);

    }

    @Test
    void equip_warrior_armor_check_Invalid_armor_type() throws InvalidLevel, InvalidArmorType {

        // Act
        String actual = "cloth cannot be used for Warrior hero ";

        Exception exception = assertThrows(InvalidArmorType.class, () -> {
            warrior.equip_armor(invalid_type_cloth);
        });
        String expected = exception.getMessage();

        assertEquals(expected, actual);

    }

    @Test
    void equip_warrior_one_armor_getStrength() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {
        // Act
        warrior.equip_armor(mail);

        double expected = warrior.totalAttributes().getStrength();

        // Assert
        double actual = 6;

        assertEquals(expected, actual);
    }

    @Test
    void equip_warrior_one_armor_getDexterity() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Act
        warrior.equip_armor(mail);

        double expected = warrior.totalAttributes().getDexterity();

        // Assert
        double actual = 2;

        assertEquals(expected, actual);
    }

    @Test
    void equip_warrior_one_armor_getIntelligence() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Act
        warrior.equip_armor(mail);

        double expected = warrior.totalAttributes().getIntelligence();

        // Assert
        double actual = 1;

        assertEquals(expected, actual);
    }



    @Test
    void equip_warrior_Two_armor() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Act
       warrior.equip_weapon(sword);
        warrior.equip_armor(plate);

        double expected = warrior.totalAttributes().getStrength();

        // Assert
        double actual = 6;

        assertEquals(expected, actual);
    }

    @Test
    void change_armor_check_total_attribute() throws InvalidLevel, InvalidWeaponType, InvalidArmorType {

        // Act
        var warrior = new Warrior("Djengis khan");
        warrior.equip_armor(mail);
        warrior.remove_armor(mail);
        warrior.equip_armor(plate);

        double expected = warrior.totalAttributes().getStrength();

        // Assert
        double actual = 6;
        assertEquals(expected, actual);
    }

}
