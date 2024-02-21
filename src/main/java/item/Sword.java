package item;

import characters.Character;

public class Sword extends Item {
    public Sword() {
        super("Sword", 100);
    }

    public Sword(String name, int power) {
        super(name, power);
    }

    @Override
    public void use() {
        if (playerCharacter != null) {
            int damage = 20;
            playerCharacter.attack();
            System.out.println(playerCharacter.getName() + " used sword and dealt "
                    + damage + " damage.");
        } else {
            System.out.println("Cannot use the sword. Player character is null.");
        }
    }
}