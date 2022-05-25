public class Edge {
    
    private Artist artist, similar;
    private int uniqueID;

    public Edge(Artist artist, Artist similar) {
        this.artist = artist;
        this.similar = similar;
        uniqueID = artist.hashCode() + similar.hashCode();
    }

    public Artist getArtist() { return artist; }
    public Artist getSimilar() { return similar; }
    public int getUniqueID() { return uniqueID; }
    public int hashCode() { return uniqueID; }

    public String toString() {
        return artist + " is similar to " + similar;
    }

    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        
        Edge other = (Edge)obj;
        return this.hashCode() == other.hashCode();
    }

}
