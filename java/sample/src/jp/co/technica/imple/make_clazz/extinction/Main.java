package jp.co.technica.imple.make_clazz.extinction;

import jp.co.technica.imple.make_clazz.extinction.character.GameCharacter;
import jp.co.technica.imple.make_clazz.extinction.character.enemy.Boss;
import jp.co.technica.imple.make_clazz.extinction.character.enemy.Enemy1;
import jp.co.technica.imple.make_clazz.extinction.character.enemy.Enemy2;
import jp.co.technica.imple.make_clazz.extinction.character.player.Cheater;
import jp.co.technica.imple.make_clazz.extinction.character.player.Player;

public class Main {

    public static void main(String[] args) {

        normalPlay();

        System.out.println();
        System.out.println("チートキャラを作りました");

        cheatPlay();

    }

    private static void normalPlay() {
        GameCharacter player = new Player();
        GameCharacter[] enemys = { new Enemy1(), new Enemy2(), new Boss() };

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

    private static void cheatPlay() {
        GameCharacter player = new Cheater();
        GameCharacter[] enemys = { new Enemy1(), new Enemy2(), new Boss() };

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