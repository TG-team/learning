package jp.co.technica.imple.make_interface.type.constant;

public class Main {

    public static void main(String[] args) {

        Employee yamada = new NonPermanent(100, 5, 1);
        Employee tanaka = new Permanent(160, 25, 10);

        System.out.println("Yamada : " + yamada.toTotalPay());
        System.out.println("Tanaka : " + tanaka.toTotalPay());
    }

}
