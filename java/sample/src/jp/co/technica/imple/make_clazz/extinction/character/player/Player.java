package jp.co.technica.imple.make_clazz.extinction.character.player;

import jp.co.technica.imple.make_clazz.extinction.character.GameCharacter;
import jp.co.technica.imple.make_clazz.extinction.character.Parameter;

public class Player implements GameCharacter {

    private State state = State.ALIVE;
    private final Parameter parameter;

    public Player() {
        this.parameter = new Parameter();
        this.parameter.hp = 100;
        this.parameter.power = 10;
        this.parameter.defense = 1;
    }

    @Override
    public void attack(GameCharacter character) {
        int damage = this.parameter.power - character.getParameter().defense;
        character.damage(Math.max(damage, 0));
    }

    @Override
    public void damage(int damage) {
        parameter.hp -= damage;
        if (parameter.hp <= 0) {
            parameter.hp = 0;
            state = State.DEAD;
        }
        System.out.println("プレイヤーの残りHP ： " + parameter.hp);
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
