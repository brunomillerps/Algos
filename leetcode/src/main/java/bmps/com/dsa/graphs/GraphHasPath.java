package bmps.com.dsa.graphs;

import java.util.*;

public class GraphHasPath {

    public static void main(String[] args) {

        Map<String, List<String>> graph = new HashMap<>();

        graph.put("A", List.of("B", "F"));
        graph.put("B", List.of("C", "D"));
        graph.put("F", List.of("G"));
        graph.put("G", List.of("A"));

        System.out.println(hasPathRecursive(graph, "A", "A", new HashSet<>()));
        System.out.println(hasPathBfs(graph, "A", "x", new HashSet<>()));

    }

    public static boolean hasPathRecursive(Map<String, List<String>> graph, String src, String dest, Set<String> visited) {
        if (src.equals(dest)) return true;
        if (visited.contains(src)) return false;

        visited.add(src);

        for (String neighbour : graph.getOrDefault(src,List.of())) {
            if (hasPathRecursive(graph, neighbour, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasPathBfs(Map<String, List<String>> graph, String src, String dest, Set<String> visited) {

        var queue = new LinkedList<String>();

        queue.offer(src);

        while (!queue.isEmpty()) {
            var element = queue.poll();
            if (element.equals(dest)) return true;
            if (visited.contains(element)) continue;

            visited.add(element);
            queue.addAll(graph.getOrDefault(element, List.of()));
        }

        return false;
    }
}
