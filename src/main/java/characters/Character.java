package characters;

import item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an abstract character in the game.
 */
public abstract class Character {
    protected String name;
    protected int level;
    protected int health;
    protected int mana;
    protected int gold;
    protected int experiencePoints;
    protected List<Item> inventory;

    /**
     * Constructor to create a character with default attributes.
     *
     * @param name The name of the character.
     */
    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.mana = 100;
        this.gold = 200;
        this.inventory = new ArrayList<>();
    }

    /**
     * Constructor to create a character with specified attributes.
     *
     * @param name   The name of the character.
     * @param level  The level of the character.
     * @param health The health of the character.
     * @param mana   The mana of the character.
     * @param gold   The gold of the character.
     */
    public Character(String name, int level, int health, int mana, int gold) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.mana = mana;
        this.gold = gold;
        this.inventory = new ArrayList<>();
    }

    /**
     * Abstract method for character to perform an attack on another character.
     *
     * @param target The target character to attack.
     */
    public abstract void attack(Character target);

    /**
     * Abstract method for character to perform an attack.
     */
    public abstract void attack();

    /**
     * Abstract method for character to use a skill.
     */
    public abstract void useSkill();

    /**
     * Gets the name of the character.
     *
     * @return The name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the character is still alive.
     *
     * @return true if the character is alive, false otherwise.
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Calculates the damage that the character can inflict.
     *
     * @return The amount of damage.
     */
    public int calculateDamage() {
        int baseDamage = 10;
        int levelMultiplier = 2;
        return baseDamage + (level * levelMultiplier);
    }

    /**
     * Applies damage to the character, reducing their health.
     *
     * @param damage The amount of damage to apply.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    /**
     * Gets the current amount of gold the character has.
     *
     * @return The amount of gold.
     */
    public int getGold() {
        return gold;
    }

    /**
     * Decreases the amount of gold the character has.
     *
     * @param amount The amount to decrease.
     */
    public void decreaseGold(int amount) {
        gold -= amount;
    }

    /**
     * Adds an item to the character's inventory.
     *
     * @param item The item to add.
     */
    public void addItemToInventory(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + " has been added to your inventory.");
    }

    /**
     * Heals the character by a specified amount.
     *
     * @param amount The amount to heal.
     */
    public void heal(int amount) {
        health = Math.min(health + amount, getMaxHealth());
    }

    /**
     * Increases the experience points of the character.
     *
     * @param experiencePoints The amount of experience points to add.
     */
    public void gainExperience(int experiencePoints) {
        this.experiencePoints += experiencePoints;
    }

    /**
     * Restores the character's mana to the maximum.
     */
    public void restoreMana() {
        mana = getMaxMana();
    }

    /**
     * Displays the character's current stats.
     */
    public void displayStats() {
        System.out.println("===== Character Stats =====");
        System.out.println("Name: " + getName());
        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "/" + getMaxHealth());
        System.out.println("Mana: " + mana + "/" + getMaxMana());
        System.out.println("Experience Points: " + experiencePoints);
    }

    /**
     * Displays the items in the character's inventory.
     */
    public void displayInventory() {
        System.out.println("===== Inventory =====");
        System.out.println("Gold: " + gold);
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Items:");
            inventory.forEach(item -> System.out.println("- " + item.getName()));
        }
    }

    /**
     * Levels up the character, improving their attributes.
     */
    public void levelUp() {
        level++;
        health += 50;
        mana += 50;
        gold += 100;
    }

    /**
     * Abstract method to get the maximum mana of the character.
     *
     * @return The maximum mana.
     */
    public abstract int getMaxMana();

    /**
     * Abstract method to get the maximum health of the character.
     *
     * @return The maximum health.
     */
    public abstract int getMaxHealth();

    /**
     * Gets the current level of the character.
     *
     * @return The level of the character.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the current health of the character.
     *
     * @return The current health.
     */
    public int getCurrentHealth() {
        return health;
    }

    /**
     * Sets the current health of the character. This method is intentionally left blank.
     *
     * @param i The intended health value.
     */
    public void setCurrentHealth(int i) {
        // Intentionally left blank.
    }
}
