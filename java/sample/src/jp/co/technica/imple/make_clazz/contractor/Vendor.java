package jp.co.technica.imple.make_clazz.contractor;

public class Vendor {

    private int id;
    private String firstName;
    private String lastName;
    private long birth;
    private String address;
    private boolean isMale;

    private Vendor(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.birth = builder.birth;
        this.address = builder.address;
        this.isMale = builder.isMale;
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

    public static class Builder {
        private int id;
        private String firstName;
        private String lastName;
        private long birth;
        private String address;
        private boolean isMale;

        public Builder(int id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder setBirth(long birth) {
            this.birth = birth;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setMale(boolean isMale) {
            this.isMale = isMale;
            return this;
        }

        public Vendor build() {
            return new Vendor(this);
        }

    }

}
