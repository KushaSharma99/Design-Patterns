import item.Item;
import item.Sword;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    private Item item;

    @Before
    public void setUp() {
        // Create an instance of Item for testing
        item = new Sword("Iron Sword", 10);
    }

    @Test
    public void testGetName() {
        // Test the getName method

        // Call the getName method to retrieve the name of the item
        String itemName = item.getName();

        // Add an assertion to check the expected outcome

        // Assert that the retrieved item name matches the expected name
        Assert.assertEquals("Iron Sword", itemName);
    }

    @Test
    public void testGetDamage() {
        // Test the getDamage method

        // Call the getDamage method to retrieve the damage value of the item
        int itemDamage = item.getDamage();

        // Add an assertion to check the expected outcome

        // Assert that the retrieved item damage matches the expected damage value
        Assert.assertEquals(10, itemDamage);
    }

    // Add more test methods to cover other functionalities of the Item class

}

