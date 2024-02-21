package race;

public class Dwarf extends Race {
    public Dwarf() {
        super("Dwarf", "Resilient and skilled craftsmen");
    }

    @Override
    public void applyPassiveSkill() {
        System.out.println("Dwarves gain bonus resistance to physical damage.");
    }
}
