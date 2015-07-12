package jp.co.technica.imple.make_interface.type.constant;

public class Permanent extends Employee {
    private static final int HOUR = 2000;

    public Permanent(int prescribed, int overtime, int midnight) {
        super(prescribed, overtime, midnight);
    }

    @Override
    public int getHourPay() {
        return HOUR;
    }

}
