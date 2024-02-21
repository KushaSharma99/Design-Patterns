package race;

public class Human extends Race {
    public Human() {
        super("Human", "Versatile and adaptable individuals");
    }

    @Override
    public void applyPassiveSkill() {
        System.out.println("Humans gain bonus experience points.");
    }
}
