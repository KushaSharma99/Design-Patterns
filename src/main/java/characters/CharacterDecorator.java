package characters;
/**
 * Decorates a Character object to add new behaviors or responsibilities.
 * This class directly references an externally mutable Character object, which is intentional
 * to allow the decorator to augment or delegate behavior to the original character.
 * This design assumes that Character objects are designed to be safely mutable by decorators.
 */

public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;
    /**
     * Constructs a CharacterDecorator wrapping a Character object.
     * @param decoratedCharacter The Character to decorate.
     */
    public CharacterDecorator(Character decoratedCharacter) {
        super(decoratedCharacter.getName());
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public void attack() {
        decoratedCharacter.attack();
    }

    @Override
    public void useSkill() {
        decoratedCharacter.useSkill();
    }
}
