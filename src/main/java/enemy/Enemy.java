package enemy;

/**
 * Represents an abstract enemy in the game. This class provides the foundation for enemy behaviors.
 */
public abstract class Enemy {
    private final String name;
    protected int health;
    private final int attackPower;
    private final int defense;
    private int experiencePoints;

    /**
     * Constructs an enemy with specified attributes.
     *
     * @param name The name of the enemy.
     * @param health The health points of the enemy.
     * @param attackPower The attack power of the enemy.
     * @param defense The defense points of the enemy.
     */
    public Enemy(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    /**
     * Performs a special move unique to the enemy.
     */
    public abstract void specialMove();

    /**
     * Gets the name of the enemy.
     *
     * @return The name of the enemy.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the health points of the enemy.
     *
     * @return The health points of the enemy.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Gets the attack power of the enemy.
     *
     * @return The attack power of the enemy.
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Gets the defense points of the enemy.
     *
     * @return The defense points of the enemy.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Abstract method for the enemy to perform an attack.
     */
    public abstract void attack();

    /**
     * Reduces the health of the enemy by the specified damage amount.
     *
     * @param damage The amount of damage to apply.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    /**
     * Checks if the enemy is still alive.
     *
     * @return true if the enemy is alive, false otherwise.
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Gets the experience points that this enemy provides when defeated.
     *
     * @return The experience points of the enemy.
     */
    public int getExperiencePoints() {
        return experiencePoints;
    }

    /**
     * Calculates the damage output of the enemy.
     *
     * @return The damage output of the enemy.
     */
    public int calculateDamage() {
        return attackPower;
    }
}
