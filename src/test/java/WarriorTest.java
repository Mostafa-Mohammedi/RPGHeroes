import no.noroff.heroes.CustomException.InvalidLevel;
import no.noroff.heroes.CustomException.InvalidWeaponType;
import no.noroff.heroes.HeroAttribute;
import no.noroff.heroes.Slot;
import no.noroff.heroes.equipment.Armor_type;
import no.noroff.heroes.equipment.Weapon_type;
import no.noroff.heroes.hero.Warrior;
import no.noroff.heroes.item.Armor;
import no.noroff.heroes.item.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    void Initialize_correct_name_level_attribute() {

        // initial level and data
        double warrior_strength = 5;
        double warrior_dexterity = 2;
        double warrior_intelligence = 1;
        double warrior_level = 1;


        var warrior = new Warrior("Djengis Khan");


        // warrior information
        String testName  = warrior.getWarrior_name();
        double test_warrior_level = warrior.getWarrior_level();

        double  test_warrior_strength = warrior.getStrength();
        double test_warrior_dexterity = warrior.getDexterity();
        double test_warrior_intelligence = warrior.getIntelligence();

        // testing
        assertEquals("Djengis Khan", testName);
        assertEquals(warrior_level, test_warrior_level);
        assertEquals(warrior_strength, test_warrior_strength);
        assertEquals(warrior_dexterity, test_warrior_dexterity);
        assertEquals(warrior_intelligence, test_warrior_intelligence);



    }

    @Test
    void Hero_level_correct_level_increase(){

        var warrior = new Warrior("Djengis Khan");

        // initial level and data
        double warrior_strength = 5;
        double warrior_dexterity = 2;
        double warrior_intelligence = 1;
        double warrior_level = 1;

        // warrior level increase state
        double  test_warrior_strength_increase = warrior.getStrength_increase_each_level();
        double test_warrior_dexterity_increase = warrior.getDexterity_increase_each_level();
        double test_warrior_intelligence_increase = warrior.getIntelligence_increase_each_level();

        //warrior stats after level increase
        double warrior_levelIncrease = 2;
        double total_warrior_level = warrior_level + warrior_levelIncrease;

        double total_strength_Increase = (total_warrior_level * test_warrior_strength_increase) + warrior_strength;
        double total_dexterity_Increase = (total_warrior_level * test_warrior_dexterity_increase) + warrior_dexterity;
        double total_intelligence_Increase = (total_warrior_level * test_warrior_intelligence_increase) + warrior_intelligence;


        // method for increasing the warrior level and stats

        warrior.levelUp(warrior_levelIncrease);

        // testing

        assertEquals(3, warrior_level + warrior_levelIncrease);
        assertEquals(((total_warrior_level * test_warrior_strength_increase) + warrior_strength), total_strength_Increase);
        assertEquals((( total_warrior_level* test_warrior_dexterity_increase) + warrior_dexterity), total_dexterity_Increase);
        assertEquals(((total_warrior_level * test_warrior_intelligence_increase) + warrior_intelligence), total_intelligence_Increase);




    }

    @Test
    void test_weapon_data_correct(){

        var weapon = new Weapon("Bronx Axe",
                1,
                Slot.WEAPON,
                1,
                Weapon_type.AXES);

        String weapon_name = weapon.get_weapon_name();
        String get_slot = weapon.get_slot();
        int required_weapon_level = weapon.get_weapon_level();



        assertEquals("Bronx Axe", weapon_name);

        assertEquals("weapon", get_slot.toLowerCase());

        assertEquals("axes", weapon.getWeaponType()
                .name()
                .toLowerCase());
        assertEquals( 1, required_weapon_level );

        assertEquals(1, weapon.getWeaponDamage());





    }

    @Test
    void test_armor_data_correct(){
        var hero_attribute = new HeroAttribute();
        hero_attribute.setStrength(3);
        var armor = new Armor("Bronx Plate",
                1,
                Slot.BODY,
                Armor_type.PLATE,
                hero_attribute);

        String armor_name = armor.get_armor_name();
        String slot =armor.get_slot();
        double required_armor_level = armor.get_armor_level();


        assertEquals("Bronx Plate", armor_name);

        assertEquals("body", slot.toLowerCase());

        assertEquals(1, required_armor_level);

        assertEquals("plate", armor.getArmorType()
                .name()
                .toLowerCase());
        assertEquals(3, armor
                .getArmorAttribute()
                .getStrength());
    }

    @Test
    void equip_warrior() throws InvalidLevel, InvalidWeaponType {

        var sword = new Weapon("legendary sword",
                1,
                Slot.WEAPON,
                1,
                Weapon_type.SWORDS);

        String weapon_type =  sword.getWeaponType().name().toLowerCase();
        String weapon_name = sword.get_weapon_name();
        double weapon_level = sword.get_weapon_level();

        var warrior = new Warrior("Djengis Khan");

        assertEquals("equipment: " +
                weapon_type + " has been added to " +
                warrior.getWarrior_name(),
                warrior.equip_weapon(weapon_name,
                        weapon_type, weapon_level));


    }


    @Test
    void equip_warrior_check_invalidWeaponType() throws InvalidLevel, InvalidWeaponType {

        var staff = new Weapon("begynner staff",
                1,
                Slot.WEAPON,
                1,
                Weapon_type.STAFF);

        String weapon_type = staff.getWeaponType().name().toLowerCase();
        String weapon_name = staff.get_weapon_name();
        double weapon_level = staff.get_weapon_level();

        var warrior = new Warrior("Djengis Khan");

        assertThrows(InvalidWeaponType.class, () -> {
            warrior.equip_weapon(weapon_name, weapon_type, weapon_level);
        });
    }

    @Test
    void equip_warrior_check_InvalidLevel() throws InvalidLevel, InvalidWeaponType {

        var sword = new Weapon("legendary sword",
                3,
                Slot.WEAPON,
                1,
                Weapon_type.SWORDS);

        String weapon_type = sword.getWeaponType().name().toLowerCase();
        String weapon_name = sword.get_weapon_name();
        double weapon_level = sword.get_weapon_level();

        var warrior = new Warrior("Djengis Khan");

        assertThrows(InvalidLevel.class, () -> {
            warrior.equip_weapon(weapon_name, weapon_type.toLowerCase(), weapon_level);
        });
    }


}