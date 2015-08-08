package jp.co.technica.imple.make_clazz.extinction.character;

public interface GameCharacter {

    public enum State {
        ALIVE, DEAD;
    }

    void attack(GameCharacter character);

    void damage(int damage);

    State getState();

    Parameter getParameter();
}
