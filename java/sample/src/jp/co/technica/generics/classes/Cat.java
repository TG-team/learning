package jp.co.technica.generics.classes;

/**
 * 猫科の動物を表すインターフェイス
 * 
 * @author fujimotoryouichi
 *
 */
public interface Cat extends Animal {

	@Override
	public String name();

	@Override
	public String bark();
}
