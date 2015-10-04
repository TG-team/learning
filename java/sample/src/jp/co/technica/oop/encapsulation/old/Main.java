package jp.co.technica.oop.encapsulation.old;

import jp.co.technica.oop.encapsulation.old.graphic.GraphicFactory;
import jp.co.technica.oop.encapsulation.old.graphic.GraphicFactory.Type;
import jp.co.technica.oop.encapsulation.old.graphic.Shape;

public class Main {

    public static void main(String[] args) {

        Shape rectangle = GraphicFactory.getRectangle(Type.CONTINUOUS, 0, 10,
                20, 30);
        // 不可視のためエラー
        // rectangle.drawLine(0, 10, 20, 30);
        // rectangle.drawCircle(0, 10, 20);
        // rectangle.getName();
        rectangle.onDraw();

        // 不可視のためエラー
        // Circle circle = new Circle(null, 0d, 0d, 0d);
        Shape circle = GraphicFactory.getCircle(Type.DASHED, 0, 10, 20);
        circle.onDraw();
    }

}
