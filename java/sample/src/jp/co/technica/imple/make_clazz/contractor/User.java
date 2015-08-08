package jp.co.technica.imple.make_clazz.contractor;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private long birth;
    private String address;
    private boolean isMale;

    public User(int id, String firstName, String lastName) {
        this(id, firstName, lastName, 0, "", true);
    }

    public User(int id, String firstName, String lastName, long birth) {
        this(id, firstName, lastName, birth, "", true);
    }

    public User(int id, String firstName, String lastName, long birth,
            String address) {
        this(id, firstName, lastName, birth, address, true);
    }

    public User(int id, String firstName, String lastName, long birth,
            String address, boolean isMale) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.address = address;
        this.isMale = isMale;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getBirth() {
        return birth;
    }

    public String getAddress() {
        return address;
    }

    public boolean isMale() {
        return isMale;
    }

}
