package dungeon;

import battle.Battle;
import characters.Character;
import enemy.BossEnemy;
import enemy.Enemy;
import enemy.MediumEnemy;
import enemy.SmallEnemy;
import item.Armor;
import item.Boots;
import item.Helmet;
import item.InstantLevelUpItem;
import item.Item;
import item.MagicScroll;
import item.Potion;
import item.Shield;
import item.Sword;
import java.util.Random;
import shop.Shop;

/**
 * Represents a dungeon in the game where characters can explore, encounter enemies, find items,
 * and visit shops.
 */
public class Dungeon {
    private int currentFloor;
    private final int maxFloor;
    private final Random random;

    /**
     * Constructs a Dungeon with a specified maximum floor.
     *
     * @param maxFloor The maximum floor the dungeon has.
     */
    public Dungeon(int maxFloor) {
        this.currentFloor = 1;
        this.maxFloor = maxFloor;
        this.random = new Random();
    }

    /**
     * Explores the current floor of the dungeon, generating encounters, finding chests, and
     * encountering shops.
     *
     * @param playerCharacter The character exploring the dungeon.
     */
    public void explore(Character playerCharacter) {
        generateEncounter(playerCharacter);

        if (findChest()) {
            Item item = generateRandomItem();
            playerCharacter.addItemToInventory(item);
        }

        if (encounterShop()) {
            Shop shop = new Shop();
            shop.enterShop(playerCharacter);
        }

        handleProgress(playerCharacter);
    }

    /**
     * Generates an encounter with an enemy based on a random selection.
     *
     * @param playerCharacter The character that encounters the enemy.
     */
    private void generateEncounter(Character playerCharacter) {
        int randomNumber = random.nextInt(3);
        Enemy enemy;

        switch (randomNumber) {
            case 0:
                enemy = new BossEnemy();
                break;
            case 1:
                enemy = new MediumEnemy();
                break;
            default:
                enemy = new SmallEnemy();
        }

        Battle battle = new Battle(playerCharacter, enemy);
        battle.startBattle();
    }

    /**
     * Determines if a chest is found during exploration.
     *
     * @return True if a chest is found, false otherwise.
     */
    private boolean findChest() {
        return random.nextDouble() < 0.3;
    }

    /**
     * Determines if a shop is encountered during exploration.
     *
     * @return True if a shop is encountered, false otherwise.
     */
    private boolean encounterShop() {
        return random.nextDouble() < 0.2;
    }

    /**
     * Generates a random item from a predefined set of items.
     *
     * @return An Item object representing the randomly generated item.
     */
    private Item generateRandomItem() {
        int randomNumber = random.nextInt(8);
        Item item;

        switch (randomNumber) {
            case 0:
                item = new Armor();
                break;
            case 1:
                item = new Boots();
                break;
            case 2:
                item = new Helmet();
                break;
            case 3:
                item = new InstantLevelUpItem();
                break;
            case 4:
                item = new MagicScroll();
                break;
            case 5:
                item = new Potion();
                break;
            case 6:
                item = new Shield();
                break;
            case 7:
                item = new Sword();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }

        return item;
    }

    /**
     * Handles the progression through the dungeon, including healing and mana restoration when
     * necessary.
     *
     * @param playerCharacter The character exploring the dungeon.
     */
    private void handleProgress(Character playerCharacter) {
        if (playerCharacter.getMaxHealth() < 0.15) {
            returnToTopFloor(playerCharacter);
        } else {
            currentFloor++;
            if (currentFloor > maxFloor) {
                provideRewards(playerCharacter);
            }
        }
    }

    /**
     * Returns the player character to the top floor of the dungeon and restores their health
     * and mana to full.
     *
     * @param playerCharacter The character to be returned to the top floor.
     */
    private void returnToTopFloor(Character playerCharacter) {
        int maxHealth = playerCharacter.getMaxHealth();
        playerCharacter.heal(maxHealth);
        playerCharacter.restoreMana();
        currentFloor = 1;
    }

    /**
     * Provides rewards to the player character after successfully exploring the dungeon.
     *
     * @param playerCharacter The character to receive the rewards.
     */
    private void provideRewards(Character playerCharacter) {
        playerCharacter.gainExperience(100);
    }

    /**
     * Gets the current floor the character is on in the dungeon.
     *
     * @return The current floor number.
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * Gets the maximum floor of the dungeon.
     *
     * @return The maximum floor number.
     */
    public int getMaxFloor() {
        return maxFloor;
    }
}
