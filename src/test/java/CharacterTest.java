import characters.Character;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the Character class functionalities.
 */
public class CharacterTest {

    private Character character;
    /**
     * Sets up the test environment before each test.
     * Initializes a character with default attributes for testing.
     */

    @Before
    public void setUp() {
        // Assuming the Character constructor signature includes the necessary parameters
        character = new Character("John", 1, 100, 100, 200) {
            @Override
            public void attack(Character target) {
                // Implementation for testing
            }

            @Override
            public void attack() {
                // Implementation for testing
            }

            @Override
            public void useSkill() {
                // Implementation for testing
            }

            @Override
            public int getMaxMana() {
                return 100; // Adjusted for consistency with the setup
            }

            @Override
            public int getMaxHealth() {
                return 100; // Adjusted for consistency with the setup
            }
        };
    }

    @Test
    public void testGetters() {
        // Test the getters of the Character class
        Assert.assertEquals("Name mismatch", "John", character.getName());
        Assert.assertEquals("Level mismatch", 1, character.getLevel());
        Assert.assertEquals("Max health mismatch", 100, character.getMaxHealth());
        Assert.assertEquals("Max mana mismatch", 100, character.getMaxMana());
        Assert.assertEquals("Initial health should be equal to max health",
                100, character.getCurrentHealth());
    }

    @Test
    public void testLevelUp() {
        // Test the level-up functionality of the Character class
        character.levelUp();
        Assert.assertEquals("Level after leveling up should increase",
                2, character.getLevel());
        Assert.assertEquals("Max health after leveling up",
                150, character.getMaxHealth());
        Assert.assertEquals("Max mana after leveling up",
                150, character.getMaxMana());
    }

    @Test
    public void testHeal() {
        character.setCurrentHealth(50);
        character.heal(25);
        Assert.assertEquals("Health after healing",
                75, character.getCurrentHealth());

        character.heal(100); // Attempt to heal beyond maxHealth
        Assert.assertEquals("Health should not exceed max health",
                100, character.getCurrentHealth());
    }

    @Test
    public void testTakeDamage() {
        character.takeDamage(30);
        Assert.assertEquals("Health after taking damage",
                70, character.getCurrentHealth());
    }
}
