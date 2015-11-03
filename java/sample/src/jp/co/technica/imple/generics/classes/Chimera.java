package jp.co.technica.imple.generics.classes;

/**
 * 犬と猫のキメラ
 *
 * @author fujimotoryouichi
 *
 */
public class Chimera implements Dog, Cat {

	@Override
	public String name() {
		return "キメラ";
	}

	@Override
	public String bark() {
		return "わゃん";
	}

}
