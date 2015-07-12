package jp.co.technica.imple.make_interface.type.constant;

public class NonPermanent extends Employee {
    private static final int HOUR = 1000;

    public NonPermanent(int prescribed, int overtime, int midnight) {
        super(prescribed, overtime, midnight);
    }

    @Override
    public int getHourPay() {
        return HOUR;
    }

}
