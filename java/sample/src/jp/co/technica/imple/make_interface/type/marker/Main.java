package jp.co.technica.imple.make_interface.type.marker;

public class Main {

    public static void main(String[] args) {
        UserCard user = new UserCard("Yamada", "0000");
        AdminCard admin = new AdminCard("Tanaka", "1111");

        LockSystem lockSystem = LockSystem.getInstance();
        // lockSystem.unlock(user);
        lockSystem.unlock(admin);
        lockSystem.lock(user);
        lockSystem.lock(admin);

    }
}
