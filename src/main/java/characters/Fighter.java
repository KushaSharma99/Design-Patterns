package characters;

public class Fighter extends Character {

    public Fighter(String name) {
        super(name);
    }

    public Fighter(String name, int level, int health, int mana, int gold) {
        super(name, level, health, mana, gold);
    }

    @Override
    public void attack(Character target) {
        System.out.println(getName() + " performs a physical attack on " + target.getName());
        int damage = calculateDamage();
        target.takeDamage(damage);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " performs a physical attack!");
    }

    @Override
    public void useSkill() {
        System.out.println(getName() + " uses Sword Slash!");
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
