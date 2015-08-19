package jp.co.technica.oop.encapsulation.graphic;

public class GraphicFactory {

    public enum Type {
        CONTINUOUS {
            @Override
            Draw getValue() {
                return DRAW_CONTINUOUS;
            }
        },
        DASHED {
            @Override
            Draw getValue() {
                return DRAW_DASHED;
            }
        },
        DOTTED {
            @Override
            Draw getValue() {
                return DRAW_DOTTED;
            }
        };

        abstract Draw getValue();

        private static final Draw DRAW_CONTINUOUS = new ContinuousDraw();
        private static final Draw DRAW_DASHED = new DashedDraw();
        private static final Draw DRAW_DOTTED = new DottedDraw();
    }

    private GraphicFactory() {
    }

    public static Shape getRectangle(Type type, double x1, double y1,
            double x2, double y2) {
        return new Rectangle(type.getValue(), x1, y1, x2, y2);
    }

    public static Shape getCircle(Type type, double x, double y, double r) {
        Circle circle = new Circle(type.getValue(), x, y, r);
        // 不可視のためエラー
        // System.out.println("x = " + circle.x);
        // System.out.println("y = " + circle.y);
        // System.out.println("r = " + circle.r);

        return circle;
    }
}
