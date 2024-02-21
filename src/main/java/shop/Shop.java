package shop;

import characters.Character;
import item.Armor;
import item.Boots;
import item.Helmet;
import item.InstantLevelUpItem;
import item.Item;
import item.MagicScroll;
import item.Potion;
import item.Shield;
import item.Sword;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents a shop where characters can purchase items.
 */
public class Shop {
    private final List<ShopItem> items;
    private final Random random; // Single instance of Random for reuse

    /**
     * Constructs a new Shop instance with a random set of items.
     */
    public Shop() {
        this.random = new Random(); // Initialize the Random instance here
        items = generateRandomItems();
    }

    /**
     * Allows a character to enter the shop and interact with the item purchase menu.
     *
     * @param playerCharacter The character entering the shop.
     */
    public void enterShop(Character playerCharacter) {
        System.out.println("Welcome to the shop! Here are the available items:");

        // Display the items in the shop
        for (int i = 0; i < items.size(); i++) {
            ShopItem shopItem = items.get(i);
            System.out.println((i + 1) + ". " + shopItem.getItem().getName() + " - " + shopItem.getPrice() + " gold");
        }

        // Prompt the player to select an item
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Enter the number of the item you want to purchase (or 0 to exit):");

        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0 || (choice >= 1 && choice <= items.size())) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 0 and " + items.size() + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        if (choice == 0) {
            System.out.println("Thank you for visiting the shop!");
            return;
        }

        ShopItem selectedShopItem = items.get(choice - 1);
        purchaseItem(playerCharacter, selectedShopItem);
    }

    /**
     * Handles the purchase of an item by a character.
     *
     * @param playerCharacter The character attempting to purchase the item.
     * @param shopItem The item being purchased.
     */
    public void purchaseItem(Character playerCharacter, ShopItem shopItem) {
        Item item = shopItem.getItem();
        int price = shopItem.getPrice();

        // Check if the player has enough money to purchase the item
        if (playerCharacter.getGold() >= price) {
            // Deduct the price from the player's money
            playerCharacter.decreaseGold(price);

            // Add the item to the player's inventory
            playerCharacter.addItemToInventory(item);

            System.out.println("You purchased " + item.getName() + " for " + price + " gold.");
        } else {
            System.out.println("You don't have enough gold to purchase this item.");
        }
    }

    /**
     * Generates a list of random items for sale in the shop.
     *
     * @return A list of ShopItem objects representing the items for sale.
     */
    public List<ShopItem> generateRandomItems() {
        List<ShopItem> generatedItems = new ArrayList<>();

        // Example: Generate random swords
        for (int i = 0; i < 3; i++) {
            String itemName = "Sword " + (i + 1);
            int itemPrice = random.nextInt(100) + 50; // Use the class-wide Random instance
            Item item = new Sword(itemName, itemPrice);
            generatedItems.add(new ShopItem(item, itemPrice));
        }

        return generatedItems;
    }
}

