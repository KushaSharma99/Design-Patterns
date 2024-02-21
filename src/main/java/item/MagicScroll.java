package item;

public class MagicScroll extends Item {

    public MagicScroll() {
        super("Magic Scroll", 50);
    }

    public MagicScroll(String name, int power) {
        super("Magic Scroll", 50);
    }

    @Override
    public void use() {
        if (playerCharacter != null) {
            playerCharacter.levelUp();
            System.out.println("Used " + getName() + " to level up the player!");
        } else {
            System.out.println("Cannot use the magic scroll. Player character is not available.");
        }
    }
}
