package jp.co.technica.imple.make_clazz.extinction.character.player;

public class Cheater extends Player {

    @Override
    public void damage(int damage) {
        super.damage(0);
    }

}
