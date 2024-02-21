package simulation;

import battle.Battle;
import characters.Character;
import dungeon.Dungeon;
import enemy.Enemy;
import floor.Floor;

/**
 * Mediates the simulation of exploring dungeons and battling enemies.
 */
public class Mediator {
    private final Dungeon dungeon;
    private final Character playerCharacter;

    /**
     * Constructs a Mediator with a dungeon and a player character.
     *
     * @param dungeon The dungeon to be explored.

     */
    public Mediator(Dungeon dungeon, Character playerCharacter) {
        this.dungeon = dungeon;
        this.playerCharacter = playerCharacter;
    }

    /**
     * Starts the dungeon exploration and battle simulation.
     */
    public void startSimulation() {
        int currentFloor = 1;

        while (currentFloor <= dungeon.getMaxFloor()) {
            System.out.println("\n=== Floor " + currentFloor + " ===");

            if (playerCharacter.getMaxHealth() <= 0.15 * playerCharacter.getMaxHealth()) {
                System.out.println("Your health is critically low! Returning to the top floor...");
                playerCharacter.heal((int) (0.85 * playerCharacter.getMaxHealth()));
                currentFloor = 1;
            } else {
                exploreFloor(currentFloor);

                if (currentFloor % 10 == 0) {
                    System.out.println("\n=== BOSS BATTLE ===");
                    Floor floor = new Floor(dungeon.getCurrentFloor());
                    Enemy boss = floor.getBoss();

                    Battle battle = new Battle(playerCharacter, boss);
                    battle.startBattle();

                    if (playerCharacter.isAlive()) {
                        System.out.println("Congratulations! you  won the game!");
                        break;
                    } else {
                        System.out.println("You were defeated by the boss. Game over!");
                        break;
                    }
                }
                currentFloor++;
            }
        }
        System.out.println("\n=== GAME OVER ===");
    }

    /**
     * Explores the specified floor of the dungeon.
     *
     * @param floorNumber The floor number to explore.
     */
    private void exploreFloor(int floorNumber) {
        Floor floor = new Floor(dungeon.getCurrentFloor());
        floor.exploreFloor(playerCharacter);
    }
}
