package jp.co.technica.imple.make_clazz.extinction;

import jp.co.technica.imple.make_clazz.extinction.character.GameCharacter;
import jp.co.technica.imple.make_clazz.extinction.character.enemy.Boss;
import jp.co.technica.imple.make_clazz.extinction.character.enemy.Enemy1;
import jp.co.technica.imple.make_clazz.extinction.character.enemy.Enemy2;
import jp.co.technica.imple.make_clazz.extinction.character.player.Cheater;
import jp.co.technica.imple.make_clazz.extinction.character.player.Player;

public class Main {

    public static void main(String[] args) {

        play(new Player(), createEnemys());
        System.out.println("●チートキャラを作りました");
        play(new Cheater(), createEnemys());

    }

    private static GameCharacter[] createEnemys() {
        return new GameCharacter[] { new Enemy1(), new Enemy2(), new Boss() };
    }

    private static void play(GameCharacter player, GameCharacter[] enemys) {

        System.out.println("========ゲーム開始========");
        for (GameCharacter enemy : enemys) {
            String enemyName = enemy.getClass().getSimpleName();
            System.out.println(enemyName + "が現れた");

            while (isAlive(player)) {
                System.out.println("--プレイヤーの攻撃");
                player.attack(enemy);

                if (isAlive(enemy)) {
                    System.out.println("----" + enemyName + "の攻撃");
                    enemy.attack(player);
                } else {
                    System.out.println(enemyName + "を倒した");
                    break;
                }
            }

            if (!isAlive(player)) {
                System.out.println("========ゲームオーバー========");
                return;
            }
        }
        System.out.println("========ゲームクリア========");
    }

    private static boolean isAlive(GameCharacter character) {
        return character.getState() == GameCharacter.State.ALIVE;
    }
}