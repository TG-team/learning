package jp.co.technica.imple.make_method.override;

public class Main {

    public static void main(String[] args) {

    	/* インスタンス作成 */
    	SuperClass superclass = new SuperClass();
    	SubClass subclass = new SubClass();

    	/* メソッド実行 */
    	superclass.test();
    	subclass.test();
    }
}
