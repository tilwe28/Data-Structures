public class City {

    private String name;
    private int uniqueID;

    public City(String name) {
        this.name = name;
        uniqueID = name.hashCode();
    }

    public String getName() { return name; }
    public int getUniqueID() { return uniqueID; }
    public int hashCode() { return uniqueID; }
    public String toString() { return name; }

    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        City other = (City)obj;
        return this.hashCode() == other.hashCode();
    }

}
