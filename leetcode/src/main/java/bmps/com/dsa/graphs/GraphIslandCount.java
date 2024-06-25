package bmps.com.dsa.graphs;

import java.util.*;

public class GraphIslandCount {

    public static void main(String[] args) {
        String[][] graph = new String[][] {
                {"W", "L", "W", "W", "L", "W"},
                {"L", "L", "W", "W", "L", "W"},
                {"W", "L", "W", "W", "W", "W"},
                {"W", "W", "W", "L", "L", "W"},
                {"W", "L", "L", "L", "L", "W"},
                {"W", "W", "W", "W", "W", "W"}
        };

        int counter = 0;
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[0].length; col++) {
                if (find(graph, row, col, visited)) {
                    counter += 1;
                }
            }
        }
        
        System.out.println(counter);
    }


    /*
                {"W", "L", "W", "W", "L", "W"},
                {"L", "L", "W", "W", "L", "W"},
                {"W", "L", "W", "W", "W", "W"},
                {"W", "W", "W", "L", "L", "W"},
                {"W", "L", "W", "L", "L", "W"},
                {"W", "W", "W", "W", "W", "W"}
     */
    private static boolean find(String[][] graph, int row, int col, Set<String> visited) {

        var isRowInbound = 0 <= row && row < graph.length;
        var isColsInbound = 0 <= col && col < graph[0].length;
        if (!isRowInbound || !isColsInbound) return false;

        if ("W".equals(graph[row][col])) return false;

        var key = row + "," + col;
        if (visited.contains(key)) return false;

        visited.add(key);

        find(graph, row + 1, col, visited);
        find(graph, row - 1, col, visited);
        find(graph, row, col + 1, visited);
        find(graph, row, col - 1, visited);

        return true;
    }
}
