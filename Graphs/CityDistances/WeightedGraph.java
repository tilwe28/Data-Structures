import java.util.*;
import java.io.*;

public class WeightedGraph {
    private HashMap<City, HashSet<Edge>> cityMap;
    private HashSet<City> cities;
    private HashSet<Edge> edges;
    private City start, end;
    private Scanner reader;

    public WeightedGraph() {
        cities = new HashSet<City>();
        ArrayList<String> cityList = new ArrayList<String>();
        edges = new HashSet<Edge>();
        cityMap = new HashMap<City, HashSet<Edge>>();
        reader = new Scanner(System.in);

        File name = new File("CityDistances.txt");
        try {
            BufferedReader input = new BufferedReader(new FileReader(name));
            String text;
            while ((text = input.readLine()) != null) {
                String[] info = text.split(",");
                String city1 = info[0];
                String city2 = info[1];
                int distance = Integer.parseInt(info[2]);
                City c1 = new City(city1);
                City c2 = new City(city2);
                if (!cityList.contains(c1.getName()))
                    cityList.add(c1.getName());
                if (!cityList.contains(c2.getName()))
                    cityList.add(c2.getName());
                cities.add(c1);
                cities.add(c2);
                edges.add(new Edge(c1, c2, distance));
                edges.add(new Edge(c2, c1, distance));

                if (!cityMap.containsKey(c1))
                    cityMap.put(c1, new HashSet<Edge>());
                if (!cityMap.containsKey(c2))
                    cityMap.put(c2, new HashSet<Edge>());
                cityMap.get(c1).add(new Edge(c1, c2, distance));
                cityMap.get(c2).add(new Edge(c2, c1, distance));
            }
        } catch (IOException io) {
            System.err.println("File does not exist");
        }

        System.out.println("Edges - Connecting cities and distances between");
        for (Edge edge : edges) {
            System.out.println("\t" + edge);
        }

        System.out.println("\nVertices - Cities");
        for (City c : cities)
            System.out.println("\t" + c);
        System.out.println();

        System.out.println();

        City start = null, end = null;

        do {
            System.out.print("Enter Starting City From List: ");
            start = new City(reader.nextLine());
        } while (!cities.contains(start));

        do {
            System.out.print("Enter Starting City From List: ");
            end = new City(reader.nextLine());
        } while (!cities.contains(end));

        Graph graph = new Graph(cities, edges);
        DijkstrasAlgorithm dijkstra = new DijkstrasAlgorithm(graph);
        dijkstra.createTravelsPaths(start);
        ArrayList<City> shortestPath = dijkstra.getShortestPath(end);
        int distance = 0;

        System.out.println("Shortest path between " + start.getName() + " to " + end.getName());
        for (int x = 0; x < shortestPath.size() - 1; x++) {
            City c1 = shortestPath.get(x);
            City c2 = shortestPath.get(x + 1);
            System.out.print("\t" + c1 + " to " + c2);
            for (Edge edge : cityMap.get(c1)) {
                if (edge.getStart().equals(c1) && edge.getDestination().equals(c2)) {
                    distance += edge.getDistance();
                    System.out.println(" -> " + edge.getDistance() + " miles.");
                }

            }
        }

        System.out.println("\tTotal Distance =  " + distance + " miles");

        /*
         * for(int a=0;a<cityList.size();a++)
         * {
         * for(int b=a+1;b<cityList.size();b++)
         * {
         * for(City city:cities)
         * {
         * if(city.getName().equals(cityList.get(a)))
         * start=city;
         * if(city.getName().equals(cityList.get(b)))
         * end=city;
         * }
         * 
         * Graph graph = new Graph(cities, edges);
         * DijkstrasAlgorithm dijkstra = new DijkstrasAlgorithm(graph);
         * dijkstra.createTravelsPaths(start);
         * ArrayList<City> shortestPath = dijkstra.getShortestPath(end);
         * int distance=0;
         * 
         * 
         * 
         * 
         * /*
         * System.out.println("Shortest path between "+start.getName()+" to "+end.
         * getName()+".");
         * 
         * for(int x=0;x<shortestPath.size()-1;x++)
         * {
         * City c1=shortestPath.get(x);
         * City c2=shortestPath.get(x+1);
         * System.out.println("\t"+c1+" to "+c2);
         * for(Edge edge:cityMap.get(c1))
         * {
         * if(edge.getStart().equals(c1) && edge.getDestination().equals(c2))
         * distance+=edge.getDistance();
         * else if(edge.getStart().equals(c2) && edge.getDestination().equals(c1))
         * distance+=edge.getDistance();
         * 
         * }
         * }
         * 
         * 
         * System.out.println("Distance between: "+distance+" miles");
         * System.out.println("\n\n");
         * 
         * }
         * }
         * 
         */
    }
}