package enemy;

public class MediumEnemy extends Enemy {

    public MediumEnemy() {
        super("Medium", 100, 20, 10);
    }

    @Override
    public void specialMove() {
        System.out.println("Quick sonic beam!");
    }

    @Override
    public void attack() {
        System.out.println("MediumEnemy attacks for " + getAttackPower() + " damage.");
    }

    @Override
    public void takeDamage(int damage) {
        health = (getHealth() - damage);
        if (!isAlive()) {
            System.out.println("MediumEnemy has been defeated!");
        }
    }
}
