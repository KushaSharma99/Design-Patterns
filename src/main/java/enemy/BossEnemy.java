package enemy;

/**
 * Represents a BossEnemy, a more powerful type of enemy in the game.
 * This class extends the Enemy class and defines specific attributes
 * including a special move and customized attack logic.
 */
public class BossEnemy extends Enemy {
    private int health;
    private final double attackDamage;

    /**
     * Constructs a BossEnemy with predefined attributes.
     */
    public BossEnemy() {
        super("Boss", 150, 30, 15);
        this.health = 100;
        // Adjust the calculation to fit within the line length limit
        this.attackDamage = calculateAttackDamage();
    }

    private double calculateAttackDamage() {
        return health * 0.1;
    }

    /**
     * Executes a special move unique to the BossEnemy.
     */
    @Override
    public void specialMove() {
        System.out.println("Boss Kamehamehaaaaa!");
    }

    @Override
    public void attack() {
        System.out.println("Boss attacks for " + attackDamage + " damage.");
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println("Boss has been defeated!");
        }
    }
}

