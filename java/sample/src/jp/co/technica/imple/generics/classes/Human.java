package jp.co.technica.imple.generics.classes;

/**
 * 人間クラス
 *
 * @author fujimotoryouichi
 *
 */
public class Human implements Animal {

	@Override
	public String name() {
		return "浜口";
	}

	@Override
	public String bark() {
		return "気合いだー！";
	}
}
