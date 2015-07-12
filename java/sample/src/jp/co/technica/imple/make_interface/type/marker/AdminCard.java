package jp.co.technica.imple.make_interface.type.marker;


public class AdminCard extends IDCard implements Lockable, Unlockable {

    public AdminCard(String name, String path) {
        super(name, path);
    }

}
