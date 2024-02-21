package item;

public class Shield extends Item {
    public Shield() {
        super("Shield", 150);
    }

    public Shield(String name, int power) {
        super("Shield", 150);
    }

    @Override
    public void use() {
        // Implement the logic for using a shield
    }
}
