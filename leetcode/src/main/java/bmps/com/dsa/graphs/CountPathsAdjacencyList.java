package bmps.com.dsa.graphs;

import java.util.*;

public class CountPathsAdjacencyList {

    public static void main(String[] args) {

        Map<String, List<String>> graph = new HashMap<>();
        String[][] edges = new String[][]{
                {"A", "B"},
                {"B", "C"},
                {"B", "E"},
                {"C", "E"},
                {"E", "D"}
        };

        for (String[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }

        Set<String> visited = new HashSet<>();
        int count = howManyPathsDFS(graph, "A", "E", visited);
        int countBfs = howManyPathsBFS(graph, "A", "E", visited);

        System.out.println(count);
        System.out.println(countBfs);
    }

    private static int howManyPathsBFS(Map<String, List<String>> graph, String source, String target, Set<String> visited) {
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String curNode = queue.poll();
                if (curNode.equals(target)) return count;

                for (String neighbour : graph.get(curNode)) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
            count += 1;
        }

        return count;
    }

    private static int howManyPathsDFS(Map<String, List<String>> graph, String source, String target, Set<String> visited) {
        if (visited.contains(source)) return 0;
        if (source.equals(target)) return 1;

        int count = 0;
        visited.add(source);

        for (String neighbour : graph.get(source)) {
            count += howManyPathsDFS(graph, neighbour, target, visited);
        }

        visited.remove(source);
        return count;
    }
}
