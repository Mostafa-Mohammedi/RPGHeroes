import no.noroff.heroes.HeroAttribute;
import no.noroff.heroes.hero.Hero;
import no.noroff.heroes.hero.Warrior;
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
    void damage() {
    }

    @Test
    void equip_armor() {
    }

    @Test
    void equip_weapon() {
    }

    @Test
    void totalAttributes() {
    }

    @Test
    void display() {
    }
}