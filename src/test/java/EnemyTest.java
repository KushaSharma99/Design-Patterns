
import enemy.Enemy;
import enemy.SmallEnemy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EnemyTest {

    private Enemy enemy;

    @Before
    public void setUp() {
        // Create an instance of Enemy for testing
        enemy = new SmallEnemy();
    }

    @Test
    public void testTakeDamage() {
        // Test the takeDamage method

        // Set the initial health of the enemy
        int initialHealth = enemy.getHealth();

        // Call the takeDamage method to inflict damage
        enemy.takeDamage(20);

        // Add assertions to check the expected outcomes

        // Assert that the enemy's health is reduced by the inflicted damage
        Assert.assertEquals(initialHealth - 20, enemy.getHealth());
    }

    @Test
    public void testAttack() {
        // Test the attack method

        // Set the initial health of the enemy and the player
        int initialEnemyHealth = enemy.getHealth();
        int initialPlayerHealth = 100;

        // Call the attack method to attack the player
        enemy.attack();

        // Add assertions to check the expected outcomes

        // Assert that the player's health is reduced due to the enemy's attack
        Assert.assertTrue(initialPlayerHealth > enemy.getHealth());

        // Assert that the enemy's health remains unchanged
        Assert.assertEquals(initialEnemyHealth, enemy.getHealth());
    }

    // Add more test methods to cover other functionalities of the Enemy class

}

