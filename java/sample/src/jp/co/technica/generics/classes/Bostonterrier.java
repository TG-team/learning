package jp.co.technica.generics.classes;

/**
 * Dog具象のボストンテリアクラス
 * 
 * @author fujimotoryouichi
 *
 */
public class Bostonterrier implements Dog {

	@Override
	public String name() {
		return "愚者（フール）";
	}

	@Override
	public String bark() {
		return "やれやれ・・・　犬好きの子供は見殺しには・・・　できねーぜ！";
	}
}
