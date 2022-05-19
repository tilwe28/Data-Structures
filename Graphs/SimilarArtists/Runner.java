import java.util.*;
import java.io.*;

public class Runner {
    
    private HashMap<Artist, HashSet<Edge>> artistMap;
    private Artist start, end;
    private Graph graph;
    private Stack<Artist> currentPath;
    private HashSet<Artist> visited;

    public Runner() {
        artistMap = new HashMap<>();
        graph = new Graph();
        File file = new File("SimilarArtists.txt");

        try {

            BufferedReader input = new BufferedReader(new FileReader(file));
            String text = "";

            while ((text=input.readLine()) != null) {
                String[] info = text.split(", ");
                Artist a1 = new Artist(info[0]);
                Artist a2 = new Artist(info[1]);
                graph.addArtist(a1);
                graph.addArtist(a2);
                graph.addEdge(a1, a2);
                graph.addEdge(a2, a1);

                if (!artistMap.containsKey(a1))
                    artistMap.put(a1, new HashSet<Edge>());
                if (!artistMap.containsKey(a2))
                    artistMap.put(a2, new HashSet<Edge>());
                
                artistMap.get(a1).add(new Edge(a1, a2));
                artistMap.get(a2).add(new Edge(a2, a1));
            }

        } catch (IOException io) {
            System.err.println("File does not exist.");
        }

        System.out.println("Edges - Connecting artists with similar");

        for (Edge edge : graph.getEdges())
            System.out.println("\t" + edge);

        for (Artist startingArtist : graph.getArtists()) {
            System.out.println(startingArtist);
            for (Artist endArtist : graph.getArtists())
                if (!startingArtist.equals(endArtist)) {
                    currentPath = new Stack<>();
                    visited = new HashSet<>();
                    dft(startingArtist, endArtist);
                }
        }
    }

    public void dft(Artist currenArtist, Artist destination) {
        currentPath.push(currenArtist);
        visited.add(currenArtist);
        if (currenArtist.equals(destination))
            printCurrentPath();
        else
            for (Edge edge : graph.getEdges()) {
                Artist artist = edge.getArtist(), similar = edge.getSimilar();
                if (visited.contains(artist) && !visited.contains(similar))
                    dft(similar, destination);
                if (!visited.contains(artist) && visited.contains(similar))
                    dft(artist, destination);
            }
    }

    public void printCurrentPath() {
        String output = "";
        while (!currentPath.isEmpty()) {
            output = currentPath.pop() + output;
            if (!currentPath.isEmpty())
                output = " -> " + output;
        }
        System.out.println("\t" + output);
    }

    public static void main(String[] args) {
        new Runner();
    }

}
