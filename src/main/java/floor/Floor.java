package floor;

import battle.Battle;
import characters.Character;
import enemy.Enemy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import shop.Shop;
import shop.ShopItem;

/**
 * Represents a floor within the game, including enemies, a boss, and possibly a shop.
 */
public class Floor {
    private final int floorNumber;
    private final List<Enemy> enemies;
    private Enemy boss;
    private final Shop shop;
    private final Random random; // Reuse the same Random instance for generating items

    /**
     * Constructs a floor with a specified floor number.
     *
     * @param floorNumber The number of the floor.
     */
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.enemies = new ArrayList<>();
        this.shop = new Shop();
        this.random = new Random(); // Initialize the Random instance
    }

    /**
     * Returns the floor number.
     *
     * @return The floor number.
     */
    public int getFloorNumber() {
        return floorNumber;
    }

    /**
     * Adds an enemy to the floor.
     *
     * @param enemy The enemy to add.
     */
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    /**
     * Returns an unmodifiable view of the list of enemies on the floor.
     * This prevents external modifications to the internal enemies list.
     *
     * @return An unmodifiable view of the list of enemies.
     */
    public List<Enemy> getEnemies() {
        return Collections.unmodifiableList(enemies);
    }

    /**
     * Sets the boss of the floor.
     *
     * @param boss The boss enemy.
     */
    public void setBoss(Enemy boss) {
        this.boss = boss;
    }

    /**
     * Returns the boss of the floor.
     *
     * @return The boss enemy.
     */
    public Enemy getBoss() {
        return boss;
    }

    /**
     * Simulates exploring the floor, including battling enemies and encountering shops or items.
     *
     * @param playerCharacter The character exploring the floor.
     */
    public void exploreFloor(Character playerCharacter) {
        System.out.println("Exploring Floor " + floorNumber + "...");
        for (Enemy enemy : enemies) {
            Battle battle = new Battle(playerCharacter, enemy);
            battle.startBattle();
        }

        if (playerCharacter.isAlive()) {
            handleFloorClearance(playerCharacter);
        } else {
            handlePlayerDefeat();
        }
    }

    private void handleFloorClearance(Character playerCharacter) {
        System.out.println("Congratulations! You cleared Floor " + floorNumber + ".");
        if (floorNumber % 5 == 0) {
            handleShopEncounter(playerCharacter);
        } else {
            handleItemDiscovery(playerCharacter);
        }
    }

    private void handleShopEncounter(Character playerCharacter) {
        System.out.println("You found a shop!");
        shop.enterShop(playerCharacter);
    }

    private void handleItemDiscovery(Character playerCharacter) {
        System.out.println("You found some items!");
        generateItems(playerCharacter);
    }

    private void generateItems(Character playerCharacter) {
        int itemCount = random.nextInt(3) + 1; // Generate 1 to 3 items

        for (int i = 0; i < itemCount; i++) {
            List<ShopItem> randomItems = shop.generateRandomItems();
            ShopItem shopItem = randomItems.get(Math.min(i, randomItems.size() - 1));
            shopItem.displayItem();
            shop.purchaseItem(playerCharacter, shopItem);
        }
    }

    private void handlePlayerDefeat() {
        System.out.println("You were defeated on Floor " + floorNumber + ". Game over!");
    }
}

