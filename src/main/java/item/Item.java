package item;

import characters.Character;

/**
 * Represents an abstract item that can be used within the game.
 */
public abstract class Item {
    private String name;
    private int value;
    protected Character playerCharacter;

    /**
     * Constructs an item with a name and value.
     *
     * @param name The name of the item.
     * @param value The value of the item.
     */
    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Abstract method to define the use of the item.
     */
    public abstract void use();

    /**
     * Sets the player character who owns this item.
     *
     * @param player The player character to associate with this item.
     */
    public void setPlayerCharacter(Character player) {
        playerCharacter = player;
    }

    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the value of the item.
     *
     * @return The value of the item.
     */
    public int getValue() {
        return value;
    }

    /**
     * Updates this item's properties to match those of the selected item.
     *
     * @param selectedItem The item whose properties are to be copied.
     */
    public void add(Item selectedItem) {
        this.name = selectedItem.name;
        this.value = selectedItem.value;
    }

    /**
     * Gets the damage value associated with the item. Default is 0 for items without damage.
     *
     * @return The damage value of the item.
     */
    public int getDamage() {
        return 0;
    }
}
