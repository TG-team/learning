package jp.co.technica.imple.make_clazz.extinction.character.enemy;

import jp.co.technica.imple.make_clazz.extinction.character.GameCharacter;
import jp.co.technica.imple.make_clazz.extinction.character.Parameter;

public class Boss implements GameCharacter {

    private State state = State.ALIVE;
    private final Parameter parameter;

    public Boss() {
        this.parameter = new Parameter();
        this.parameter.hp = 50;
        this.parameter.power = 6;
        this.parameter.defense = 3;
    }

    @Override
    public void attack(GameCharacter character) {
        character.damage(parameter.power * 2);
    }

    @Override
    public void damage(int damage) {
        parameter.hp -= damage / 2;
        if (parameter.hp <= 0) {
            state = State.DEAD;
        }
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public Parameter getParameter() {
        return parameter;
    }

}
