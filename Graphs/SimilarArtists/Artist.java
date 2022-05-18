public class Artist {
    
    private String name;
    private int uniqueID;

    public Artist(String name) {
        this.name = name;
        uniqueID = name.hashCode();
    }

    public String getName() { return name; }
    public int getUniqueID() { return uniqueID; }
    public String toString() { return name; }

    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Artist other = (Artist)obj;
        return this.getUniqueID() == other.getUniqueID();
    }

}
