package jp.co.technica.generics.classes;

/**
 * 動物全般（人間含む）を表すインターフェス
 * 
 * @author fujimotoryouichi
 *
 */
public interface Animal {
	
	/** 名前を返します */
	public String name();

	/** 鳴き声を返します */
	public String bark();
}