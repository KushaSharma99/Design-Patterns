package item;

public class InstantLevelUpItem extends Item {
    public InstantLevelUpItem() {

        super("Instant Level Up", 500);
    }

    public InstantLevelUpItem(String name, int power) {
        super(name, power);
    }

    @Override
    public void use() {
        if (playerCharacter != null) {
            playerCharacter.levelUp();
            System.out.println("Used " + getName() + " to instantly level up!");
        }
    }
}
