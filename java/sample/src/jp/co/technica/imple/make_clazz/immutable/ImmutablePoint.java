package jp.co.technica.imple.make_clazz.immutable;

public class ImmutablePoint {

    private final int x;
    private final int y;

    private ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static ImmutablePoint valueOf(int x, int y) {
        return new ImmutablePoint(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ImmutablePoint other = (ImmutablePoint) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ImmutablePoint [x=" + x + ", y=" + y + "]";
    }

}
