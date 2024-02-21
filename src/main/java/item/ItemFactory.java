package item;

import java.util.Random;

/**
 * Factory class for creating random items.
 * Utilizes the ItemType enum to generate specific items with random attributes.
 */
public class ItemFactory {
    private final Random random;

    /**
     * Constructs an ItemFactory with a new instance of Random.
     */
    public ItemFactory() {
        random = new Random();
    }

    /**
     * Creates a random item based on the ItemType.
     * The item's type determines its name and power attributes.
     *
     * @return A new item instance with randomized attributes.
     */
    public Item createRandomItem() {
        ItemType.Type itemType = getRandomItemType();
        String name = generateRandomItemName(itemType);
        int power = generateRandomPower();

        switch (itemType) {
            case SWORD:
                return new Sword(name, power);
            case SHIELD:
                return new Shield(name, power);
            case HELMET:
                return new Helmet(name, power);
            case ARMOR:
                return new Armor(name, power);
            case BOOTS:
                return new Boots(name, power);
            case MAGIC_SCROLL:
                return new MagicScroll(name, power);
            case POTION:
                return new Potion(name, power);
            case INSTANT_LEVEL_UP:
                return new InstantLevelUpItem(name, power);
            default:
                throw new IllegalStateException("Unexpected value: " + itemType);
        }
    }

    /**
     * Selects a random ItemType.
     *
     * @return A randomly selected ItemType.
     */
    private ItemType.Type getRandomItemType() {
        ItemType.Type[] itemTypes = ItemType.Type.values();
        int index = random.nextInt(itemTypes.length);
        return itemTypes[index];
    }

    /**
     * Generates a random item name based on the item type.
     *
     * @param itemType The type of item for which to generate a name.
     * @return A string representing the item's name.
     */
    private String generateRandomItemName(ItemType.Type itemType) {
        String prefix = "";
        String suffix = "";

        switch (itemType) {
            case SWORD:
                prefix = "Sharp";
                suffix = "Sword";
                break;
            case SHIELD:
                prefix = "Sturdy";
                suffix = "Shield";
                break;
            case HELMET:
                prefix = "Strong";
                suffix = "Helmet";
                break;
            case ARMOR:
                prefix = "Heavy";
                suffix = "Armor";
                break;
            case BOOTS:
                prefix = "Swift";
                suffix = "Boots";
                break;
            case MAGIC_SCROLL:
                prefix = "Mystical";
                suffix = "Scroll";
                break;
            case POTION:
                prefix = "Healing";
                suffix = "Potion";
                break;
            case INSTANT_LEVEL_UP:
                prefix = "Potent";
                suffix = "Elixir";
                break;
            default:
                throw new IllegalArgumentException("Invalid item type.");
        }

        return prefix + " " + suffix;
    }

    /**
     * Generates a random power value for an item.
     *
     * @return A random integer representing the item's power.
     */
    private int generateRandomPower() {
        return random.nextInt(90) + 1; // Generates a power between 1 and 90
    }
}

