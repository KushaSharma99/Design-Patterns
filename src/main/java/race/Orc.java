package race;

public class Orc extends Race {
    public Orc() {
        super("Orc", "Strong and fierce warriors");
    }

    @Override
    public void applyPassiveSkill() {
        System.out.println("Orcs gain bonus strength and attack power.");
    }
}
