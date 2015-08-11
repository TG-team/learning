package jp.co.technica.imple.make_clazz.compare;

public class Photo implements Cloneable {

    private String path;
    private String name;
    private long size;
    private long date;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (date ^ (date >>> 32));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((path == null) ? 0 : path.hashCode());
        result = prime * result + (int) (size ^ (size >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Photo other = (Photo) obj;
        if (date != other.date)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (path == null) {
            if (other.path != null)
                return false;
        } else if (!path.equals(other.path))
            return false;
        if (size != other.size)
            return false;
        return true;
    }

    @Override
    protected Photo clone() {
        Photo photo = null;

        try {
            photo = (Photo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return photo;
    }

    @Override
    public String toString() {
        return "Photo [path=" + path + ", name=" + name + ", size=" + size
                + ", date=" + date + "]";
    }

}
