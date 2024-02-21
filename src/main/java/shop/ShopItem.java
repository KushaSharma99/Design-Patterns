package shop;

import item.Item;

/**
 * Represents an item for sale in the shop.
 * Contains the item and its price.
 */
public class ShopItem {
    private final Item item;
    private final int price;

    /**
     * Constructs a ShopItem with the specified item and its price.
     *
     * @param item The item to be sold in the shop. It's assumed that Item is immutable
     *             or changes to the Item object after it's passed to ShopItem won't affect ShopItem's integrity.
     * @param price The price of the item.
     */
    public ShopItem(Item item, int price) {
        this.item = item;
        this.price = price;
    }

    /**
     * Gets the item.
     * Note: If Item is mutable, consider returning a defensive copy or ensuring Item is effectively immutable.
     *
     * @return The item.
     */
    public Item getItem() {
        return item;
    }

    /**
     * Gets the price of the item.
     *
     * @return The price of the item.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Displays the item's name and price.
     */
    public void displayItem() {
        System.out.println("Item: " + item.getName());
        System.out.println("Price: " + price);
    }
}
