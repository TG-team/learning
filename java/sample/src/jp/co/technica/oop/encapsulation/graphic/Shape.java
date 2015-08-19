package jp.co.technica.oop.encapsulation.graphic;


public abstract class Shape {

    protected Draw draw;

    Shape(Draw draw) {
        this.draw = draw;
    }

    public abstract void onDraw();

    protected void drawLine(double x1, double y1, double x2, double y2) {
        draw.line(x1, y1, x2, y2);
    }

    protected void drawCircle(double x, double y, double r) {
        draw.circle(x, y, r);
    }

}
