import characters.Character;
import characters.Fighter;
import characters.Mage;
import characters.Thief;
import dungeon.Dungeon;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Dungeon dungeon;
    private static Character playerCharacter;

    public static void main(String[] args) {
        displayMainMenu();
        int choice = getUserInput(3);

        switch (choice) {
            case 1:
                startNewGame();
                break;
            case 2:
                loadGame();
                break;
            case 3:
                exitGame();
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }

    private static void displayMainMenu() {
        System.out.println("===== Main Menu =====");
        System.out.println("1. Start New Game");
        System.out.println("2. Load Game");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserInput(int max) {
        int choice;
        do {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            if (choice < 1 || choice > max) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (choice < 1 || choice > max);
        return choice;
    }

    private static void startNewGame() {
        System.out.print("Enter your character name: ");
        String name = scanner.next();
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Choose your character class:");
        System.out.println("1. Fighter");
        System.out.println("2. Mage");
        System.out.println("3. Thief");
        int classChoice = getUserInput(3);

        switch (classChoice) {
            case 1:
                playerCharacter = new Fighter(name);
                break;
            case 2:
                playerCharacter = new Mage(name);
                break;
            case 3:
                playerCharacter = new Thief(name);
                break;
            default:
                System.out.println("Invalid class selection. Defaulting to Fighter.");
                playerCharacter = new Fighter(name);
                break;
        }

        dungeon = new Dungeon(1);

        gameLoop();
    }

    private static void gameLoop() {
        boolean running = true;
        while (running) {
            displayGameMenu();
            int choice = getUserInput(4);

            switch (choice) {
                case 1:
                    dungeon.explore(playerCharacter);
                    break;
                case 2:
                    playerCharacter.displayStats();
                    break;
                case 3:
                    playerCharacter.displayInventory();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    private static void displayGameMenu() {
        System.out.println("\n===== Game Menu =====");
        System.out.println("1. Explore Dungeon");
        System.out.println("2. View Character Stats");
        System.out.println("3. View Inventory");
        System.out.println("4. Quit Game");
        System.out.print("Enter your choice: ");
    }

    private static void loadGame() {
        System.out.println("Loading game...");
        // Placeholder for loading game functionality
    }

    private static void exitGame() {
        System.out.println("Exiting game...");
        System.exit(0);
    }
}
