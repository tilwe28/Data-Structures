import java.util.*;

public class DijkstrasAlgorithm {

    private ArrayList<City> cities;
    private ArrayList<Edge> edges;
    private HashSet<City> visitedCities;
    private HashSet<City> unVisitedCities;
    private HashMap<City, City> predecessors;
    private HashMap<City, Integer> distance;

    public DijkstrasAlgorithm(Graph graph) {
        this.cities = new ArrayList<City>(graph.getCities());
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }

    public void createTravelsPaths(City source) {
        visitedCities = new HashSet<City>();
        unVisitedCities = new HashSet(cities); // new HashSet<City>();
        distance = new HashMap<City, Integer>();
        predecessors = new HashMap<City, City>();
        distance.put(source, 0); // Distance from starting city
        // unVisitedCities.add(source);
        while (unVisitedCities.size() > 0) { // Keep going until all visited
            City city = getMinimum(unVisitedCities);
            visitedCities.add(city);
            unVisitedCities.remove(city);
            findMinimalDistances(city);
        }
    }

    public HashMap<City, City> getPred() {
        return predecessors;
    }

    /*************** WORK ON THESE TWO **************/
    // Update distance Map for adjacent nodes
    private void findMinimalDistances(City tempCity) {
        ArrayList<City> adjacentNodes = getNeighbors(tempCity);
        for (City targetCity : adjacentNodes) {
            if (getShortestDistance(targetCity) > getShortestDistance(tempCity) + getDistance(tempCity, targetCity)) {
                distance.put(targetCity, getShortestDistance(tempCity) + getDistance(tempCity, targetCity)); // update
                                                                                                             // dist
                                                                                                             // table
                predecessors.put(targetCity, tempCity);
            }
        }
    }

    private int getShortestDistance(City destination) {
        Integer dist = distance.get(destination);
        if (dist == null)
            return Integer.MAX_VALUE;
        else
            return dist;
    }

    /*************************************************/

    // Gets the int distance between connected nodes. Should only be called on nodes
    // known to be connected.
    private int getDistance(City tempCity, City targetCity) {
        for (Edge edge : edges) {
            if ((edge.getStart().equals(tempCity) && edge.getDestination().equals(targetCity))
                    || (edge.getStart().equals(targetCity) && edge.getDestination().equals(tempCity)))
                return edge.getDistance();
        }
        throw new RuntimeException("Should not happen");
    }

    // Gets all nodes immmediately adjacent to tempCity
    private ArrayList<City> getNeighbors(City tempCity) {
        ArrayList<City> neighbors = new ArrayList<City>();
        for (Edge edge : edges) {
            if (edge.getStart().equals(tempCity) && !wasVisited(edge.getDestination()))
                neighbors.add(edge.getDestination());
            if (edge.getDestination().equals(tempCity) && !wasVisited(edge.getStart()))
                neighbors.add(edge.getStart());
        }
        return neighbors;
    }

    private City getMinimum(HashSet<City> cities) {
        City minimum = null;
        for (City city : cities) {
            if (minimum == null) // Set Min to first City
            {
                minimum = city;
            } else if (getShortestDistance(city) < getShortestDistance(minimum)) // replace min with closest
            {
                minimum = city;
            }
        }
        return minimum;
    }

    private boolean wasVisited(City city) {
        return visitedCities.contains(city);
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public ArrayList<City> getShortestPath(City target) {
        ArrayList<City> connectingCities = new ArrayList<City>();
        City step = target;
        // check if a path exists
        if (predecessors.get(step) == null)
            return null;

        connectingCities.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            connectingCities.add(step);
        }
        // Put it into the correct order
        Collections.reverse(connectingCities);
        return connectingCities;
    }

}