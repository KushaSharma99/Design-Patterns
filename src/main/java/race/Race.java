package race;

public abstract class Race {
    private final String name;
    private final String description;

    public Race(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract void applyPassiveSkill();
}
