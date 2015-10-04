package jp.co.technica.oop.encapsulation.old.graphic;


final public class Circle extends Shape {
    private final double x;
    private final double y;
    private final double r;

    Circle(Draw draw, double x, double y, double r) {
        super(draw);
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void onDraw() {
        drawCircle(x, y, r);
    }

}
