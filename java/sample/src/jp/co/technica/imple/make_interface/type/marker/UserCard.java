package jp.co.technica.imple.make_interface.type.marker;

public class UserCard extends IDCard implements Lockable {

    public UserCard(String name, String path) {
        super(name, path);
    }

}
