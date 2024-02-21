package characters;

/**
 * Factory class for creating instances of different types of characters.
 */
public class CharacterFactory {

    /**
     * Creates a character of the specified type.
     *
     * @param name The name of the character to be created.
     * @param characterType The type of the character to be created.
     * @return A new instance of the specified character type.
     */
    public static Character createCharacter(String name, String characterType) {
        Character character = null;
        switch (characterType) {
            case "Fighter":
                character = new Fighter(name);
                break;
            case "Mage":
                character = new Mage(name);
                break;
            case "Thief":
                character = new Thief(name);
                break;
            default:
                // Default character type if not recognized
                character = new Fighter(name);
                break;
        }
        return character;
    }
}
