# RPG Heroes

Console app for creating heroes character and their Equipment.
The equipment will increase the state of the heroes.
Heroes can use certain equipment  similar to their character example staff for mage and sword for Warrior.


## Setup

Every hero start at level 1 and initial hero attribute example:


| hero    | Strength | Dexterity | Intelligence |
|---------|---|---|---|
 | Mage    | 1 | 1 | 8 |
| Range   | 1 | 7 | 1 |
| Rogue   | 2 | 6 | 1 |
| Warrior | 5 | 2 | 1 |


## Classes

The Console app will contain following character:

* Hero Abstract class


* Contains the heroes name and characteristic

  * Mage class extends from Hero class 
  * Ranger class extends from hero class
  * Rogue class extends from hero class
  * Warrior class extends from hero class


* Hero Attributes class
  * Add the hero strength, dexterity and intelligence

* Items abstract class
  * Weapon extends from Item class
  * Armor extends from Item class


## Class diagram

![img.png](img.png)


* Every Test_Hero type will extend several Method from the Test_Hero class

  * LevelUp: increase the level of the hero
  * Damage: is the damage a hero deals 
  * equip_armor: method to equip the armor of the hero
  * equip_weapon: method to equip a weapon to the hero
  * totalAttributes: the total level of the hero including the heroes stats
  * display: the total state of the hero including their name and class
  



