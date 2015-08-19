package jp.co.technica.oop.encapsulation.graphic;


final public class Rectangle extends Shape {

    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;

    Rectangle(Draw draw, double x1, double y1, double x2, double y2) {
        super(draw);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void onDraw() {
        drawLine(x1, y1, x2, y1);
        drawLine(x2, y1, x2, y2);
        drawLine(x2, y2, x1, y2);
        drawLine(x1, y2, x1, y1);
    }

    private String getName() {
        return Rectangle.class.getSimpleName();
    }

}
