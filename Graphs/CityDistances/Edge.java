public class Edge {
    
    private City start, destination;
    private int distance;
    private int uniqueID;

    public Edge(City start, City destination, int distance) {
        this.start = start;
        this.destination = destination;
        this.distance = distance;
        uniqueID = start.hashCode() + destination.hashCode();
    }

    public City getStart() { return start; }
    public City getDestination() { return destination; }
    public int getDistance() { return distance; }
    public int getUniqueID() { return uniqueID; }
    public int hashCode() { return uniqueID; }

    public String toString() {
        return start + " is " + distance + " miles from " + destination;
    }

    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Edge other = (Edge)obj;
        return this.hashCode() == other.hashCode();
    }

}
