package enemy;

public class SmallEnemy extends Enemy {

    public SmallEnemy() {
        super("Small", 50, 10, 5);
    }

    @Override
    public void specialMove() {
        System.out.println("Energy disc!");
    }

    @Override
    public void attack() {
        System.out.println("SmallEnemy attacks for " + getAttackPower() + " damage.");
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (!isAlive()) {
            System.out.println("SmallEnemy has been defeated!");
        }
    }
}
