package jp.co.technica.imple.make_interface.type.marker;

public abstract class IDCard {

    private String name;
    private String path;

    public IDCard(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "[name=" + name + ", path=" + path + "]";
    }

}
