import no.noroff.heroes.hero.HeroAttribute;
import no.noroff.heroes.equipment.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.item.Armor;
import no.noroff.heroes.item.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Item {
    private Weapon weapon;
    private Armor armor;


    @BeforeEach
    void init(){

        // Arrange
        weapon = new Weapon("Bronx Axe",
                1,
                Slot.WEAPON,
                1,
                Weapon_type.AXES);

        armor = new Armor("Bronx Plate",
                1,
                Slot.BODY,
                Armor_type.PLATE,
                new HeroAttribute(1,0,0));


    }

    @Test
    void check_weapon_name_correct(){

        // Act
        String actual = weapon.get_weapon_name();
        // Assert
        String expected = "Bronx Axe";

        assertEquals(expected, actual);

    }


    @Test
    void check_weapon_slot_name_correct(){
        // Act
        String actual = weapon.get_slot().toLowerCase();

        // Assert
        String expected = "weapon";

        assertEquals(expected, actual);

    }

    @Test
    void check_weapon_damage_correct(){
        // Act
        int actual = weapon.getWeaponDamage();

        // Assert
        int expected = 1;

        assertEquals(expected, actual);

    }




    @Test
    void check_weapon_type_correct(){
        // Act
        String actual = weapon.getWeaponType().name().toLowerCase();

        // Assert
        String expected = "axes";

        assertEquals(expected, actual);


    }


    @Test
    void check_armor_name_correct(){

        // Act
        String expected = armor.get_armor_name().toLowerCase();

        // Assert
        String actual = "bronx plate";
        assertEquals(expected, actual);

    }

    @Test
    void check_armor_level_correct(){

        // Act

        int expected = armor.get_armor_level();

        // Assert
        int actual = 1;
        assertEquals(expected, actual);

    }


    @Test
    void check_armor_slot_correct(){

        // Act
        String actual = armor.get_slot().toLowerCase();

        // Assert
        String expected = "body";
        assertEquals(expected, actual);

    }

}
