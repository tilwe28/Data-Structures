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

            while ((text = input.readLine()) != null) {
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

            input.close();

        } catch (IOException io) {
            System.err.println("File does not exist.");
        }

        System.out.println("Edges - Connecting artists with similar");

        for (Edge edge : graph.getEdges())
            System.out.println("\t" + edge);

        // for (Artist startingArtist : graph.getArtists()) {
        //     System.out.println(startingArtist);
        //     for (Artist endArtist : graph.getArtists())
        //         if (!startingArtist.equals(endArtist)) {
        //             currentPath = new Stack<>();
        //             visited = new HashSet<>();
        //             dft(startingArtist, endArtist);
        //         }
        // }

        currentPath = new Stack<>();
        visited = new HashSet<>();
    }

    public void dft(Artist currentArtist, Artist destination) {
        currentPath.push(currentArtist);
        visited.add(currentArtist);
        if (currentArtist.equals(destination))
            printCurrentPath();
        else
            for (Edge edge : graph.getEdges()) {
                Artist artist = edge.getArtist(), similar = edge.getSimilar();
                if (visited.contains(artist) && !visited.contains(similar))
                    dft(similar, destination);
                if (!visited.contains(artist) && visited.contains(similar))
                    dft(artist, destination);
            }

        currentPath = new Stack<>();
        visited = new HashSet<>();
    }

    public void bft(Artist currentArtist, Artist destination) {
        Queue<Artist> q = new LinkedList<>();
        Map<Artist, Artist> prev = new HashMap<>();
        visited.clear();

        q.add(currentArtist);
        Artist a = currentArtist;
        while (!q.isEmpty() && !(a=q.poll()).equals(destination)) {
            for (Edge e : graph.getEdges()) {
                if (e.getArtist().equals(a) && !visited.contains(e.getSimilar())) {
                    q.add(e.getSimilar());
                    prev.put(e.getSimilar(), a);
                }
            }

            visited.add(a);
        }

        if (!a.equals(destination)) {
            System.out.println("No connection found");
            return;
        }

        String output = a.toString();
        while (prev.get(a) != null && !prev.get(a).equals(currentArtist)) {
            a = prev.get(a);
            output = a + " -> " + output;
        }
        System.out.println(currentArtist + " -> " + output);
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
        Runner sat = new Runner();

        System.out.println("\n\nDFT: Benee to LoveLeo");
        sat.dft(new Artist("Benee"), new Artist("LoveLeo"));

        System.out.println("BFT: Benee to LoveLeo"); 
        sat.bft(new Artist("Benee"), new Artist("LoveLeo"));

        // No Connection
        System.out.println("\n___ NO CONNECTION____"); 
        System.out.println("DFT: FastBall to T.J."); 
        sat.dft(new Artist("FastBall"), new Artist("T.J."));
        System.out.println("BFT: FastBall to T.J."); 
        sat.bft(new Artist("FastBall"), new Artist("T.J."));
    }

}
