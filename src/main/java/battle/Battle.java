package battle;

import characters.Character;
import enemy.Enemy;

/**
 * Represents a battle between a player character and an enemy.
 */
public class Battle {
    private final Character player;
    private final Enemy enemy;

    /**
     * Creates a battle instance between a player and an enemy.
     *
     * @param player The player character participating in the battle.
     * @param enemy The enemy character the player is battling against.
     */
    public Battle(Character player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    /**
     * Starts the battle between the player and the enemy.
     */
    public void startBattle() {
        System.out.println("A new challenger has arrived!");
        System.out.println(player.getName() + " takes on " + enemy.getName());

        while (player.isAlive() && enemy.isAlive()) {
            attack(player, enemy);
            if (enemy.isAlive()) {
                attack(enemy, player);
            }
        }

        declareWinner();
    }

    private void attack(Enemy attacker, Character target) {
        int damage = attacker.calculateDamage();
        target.takeDamage(damage);
        System.out.println(attacker.getName() + " attacks " + target.getName()
                + " and deals " + damage + " damage.");
    }

    private void attack(Character target, Enemy attacker) {
        int damage = attacker.calculateDamage();
        target.takeDamage(damage);
        System.out.println(attacker.getName() + " attacks " + target.getName()
                + " and deals " + damage + " damage.");
    }

    private void declareWinner() {
        if (player.isAlive()) {
            System.out.println("Player wins the battle!");
        } else {
            System.out.println("Enemy wins the battle!");
        }
    }
}
