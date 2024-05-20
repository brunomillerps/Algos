package bmps.com.graphs;

import java.util.*;

public class GraphComponentsCount {

    public static void main(String[] args) {

        Map<String, List<String>> graph = new HashMap<>();

        graph.put("1", List.of("2"));
        graph.put("2", List.of());

        graph.put("4", List.of("6"));
        graph.put("6", List.of("5", "7", "8"));
        graph.put("5", List.of());
        graph.put("7", List.of("3"));
        graph.put("8", List.of());

        graph.put("3", List.of());

        System.out.println(numberOfIslands(graph));
    }

    private static int numberOfIslands(Map<String, List<String>> graph) {
        int counter = 0;
        var visited = new HashSet<String>();

        for (var entry : graph.entrySet()) {

            if (numberOfIslandsSearch(graph, entry.getKey(), visited)) {
                counter += 1;
            }
        }

        return counter;
    }

    private static boolean numberOfIslandsSearch(Map<String, List<String>> graph, String node, Set<String> visited) {
        if (visited.contains(node)) return false;

        visited.add(node);

        for (String neighbour : graph.get(node)) {
            numberOfIslandsSearch(graph, neighbour, visited);
        }

        return true;
    }
}
