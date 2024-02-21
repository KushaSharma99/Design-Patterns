package characters;

public class Mage extends Character {

    public Mage(String name) {
        super(name);
    }

    public Mage(String name, int level, int health, int mana, int gold) {
        super(name, level, health, mana, gold);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " casts a spell on " + target.getName());
        int damage = calculateDamage();
        target.takeDamage(damage);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " casts a spell!");
    }

    @Override
    public void useSkill() {
        System.out.println(getName() + " casts Fireball!");
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
