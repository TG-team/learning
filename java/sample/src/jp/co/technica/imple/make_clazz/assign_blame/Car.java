package jp.co.technica.imple.make_clazz.assign_blame;

public class Car {

    private final Engine engine = new Engine(0);

    public Car() {
    }

    public int getFuelLevel() {
        return this.engine.getFuel();
    }

    public void setFuel(int fuel) {
        this.engine.setFuel(fuel);
    }
}
