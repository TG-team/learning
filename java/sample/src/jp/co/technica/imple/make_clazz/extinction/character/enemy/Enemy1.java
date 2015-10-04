package jp.co.technica.imple.make_clazz.extinction.character.enemy;

import jp.co.technica.imple.make_clazz.extinction.character.GameCharacter;
import jp.co.technica.imple.make_clazz.extinction.character.Parameter;

public class Enemy1 implements GameCharacter {

    private State state = State.ALIVE;
    private final Parameter parameter;

    public Enemy1() {
        this.parameter = new Parameter();
        this.parameter.hp = 10;
        this.parameter.power = 2;
        this.parameter.defense = 1;
    }

    @Override
    public void attack(GameCharacter character) {
        character.damage(parameter.power);
    }

    @Override
    public void damage(int damage) {
        parameter.hp -= damage;
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
