package item;

/**
 * Represents a Potion item that can be used by characters.
 * This class extends the abstract Item class and provides implementation for the potion's effects.
 */
public class Potion extends Item {

    /**
     * Constructs a default Potion with predefined name and power.
     */
    public Potion() {
        super("Potion", 20);
    }

    /**
     * Constructs a Potion with custom name and power.
     *
     * @param name The name of the potion.
     * @param power The power of the potion.
     */
    public Potion(String name, int power) {
        super(name, power);
    }

    /**
     * Uses the potion to restore health points to the player character.
     * If the player character is null.
     */
    @Override
    public void use() {
        if (playerCharacter != null) {
            int restoredHealth = 50; // Example: restoring 50 health points
            playerCharacter.heal(restoredHealth);
            System.out.println("Used " + getName() + " to restore " + restoredHealth
                    + " health points for " + playerCharacter.getName() + ".");
        } else {
            System.out.println("Cannot use the potion. Player character is null.");
        }
    }
}
