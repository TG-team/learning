package jp.co.technica.imple.make_interface.type.constant;

public abstract class Employee {

    /** 法定時間内労働時間 */
    private int prescribed = 0;
    /** 法定外労働時間(通常残業) */
    private int overtime = 0;
    /** 法定外休日労働時間(深夜残業) */
    private int midnight = 0;

    public Employee(int prescribed, int overtime, int midnight) {
        this.prescribed = prescribed;
        this.overtime = overtime;
        this.midnight = midnight;
    }

    public abstract int getHourPay();

    private int getPrescribedMoney() {
        return prescribed * getHourPay() * Rate.PRESCRIBED_TIME;
    }

    private int getOvertimeMoney() {
        return overtime * getHourPay() * Rate.OVERTIME;
    }

    private int getMidnightMoney() {
        return midnight * getHourPay() * Rate.MIDNIGHT_OVERTIME;
    }

    public int toPay() {
        return (getPrescribedMoney() + getOvertimeMoney() + getMidnightMoney()) / 100;
    }
}
