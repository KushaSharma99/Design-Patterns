package enemy;

public class EnemyFactory {
    // Define constants for enemy types
    public static final String SMALL_ENEMY = "Small";
    public static final String MEDIUM_ENEMY = "Medium";
    public static final String BOSS_ENEMY = "Boss";

    /**
     * Creates an enemy of the specified type.
     *
     * @param type The type of enemy to create.
     * @return An instance of the specified enemy type.
     * @throws IllegalArgumentException if the given type is not recognized.
     */
    public Enemy createEnemy(String type) {
        switch (type) {
            case SMALL_ENEMY:
                return new SmallEnemy();
            case MEDIUM_ENEMY:
                return new MediumEnemy();
            case BOSS_ENEMY:
                return new BossEnemy();
            default:
                throw new IllegalArgumentException("Invalid enemy type: " + type);
        }
    }
}
