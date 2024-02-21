package race;

public class Elf extends Race {
    public Elf() {
        super("Elf", "Agile and graceful beings");
    }

    @Override
    public void applyPassiveSkill() {
        System.out.println("Elves gain bonus evasion and accuracy.");
    }
}
