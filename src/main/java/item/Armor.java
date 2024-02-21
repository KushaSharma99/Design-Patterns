package item;

public class Armor extends Item {
    public Armor() {
        super("Armor", 200);
    }

    public Armor(String name, int power) {
        super(name, power);
    }

    @Override
    public void use() {
        System.out.println("Equipped " + getName() + " for protection.");
    }
}
