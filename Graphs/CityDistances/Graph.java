import java.util.*;

public class Graph {

    private Set<City> cities;
    private Set<Edge> edges;

    public Graph(Set<City> cities, Set<Edge> edges) {
        this.cities = cities;
        this.edges = edges;
    }

    public Set<City> getCities() { return cities; }
    public Set<Edge> getEdges() { return edges; }

    public void addCity(City city) {
        cities.add(city);
    }

    public void addEdge(City source, City destination, int distance) {
        edges.add(new Edge(source, destination, distance));
    }

}