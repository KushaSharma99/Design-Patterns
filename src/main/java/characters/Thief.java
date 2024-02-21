package characters;

public class Thief extends Character {

    public Thief(String name) {
        super(name);
    }

    public Thief(String name, int level, int health, int mana, int gold) {
        super(name, level, health, mana, gold);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " performs a regular attack on " + target.getName());
        int damage = calculateDamage();
        target.takeDamage(damage);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " performs a sneak attack!");
    }

    @Override
    public void useSkill() {
        System.out.println(getName() + " uses Backstab!");
    }

    @Override
    public int getMaxMana() {
        return 0;
    }

    @Override
    public int getMaxHealth() {
        return 0;
    }
}
