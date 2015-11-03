package jp.co.technica.imple.generics.classes;

/**
 * 犬科の動物を表すインターフェイス
 *
 * @author fujimotoryouichi
 *
 */
public interface Dog extends Animal {

	@Override
	public String name();

	@Override
	public String bark();

}
