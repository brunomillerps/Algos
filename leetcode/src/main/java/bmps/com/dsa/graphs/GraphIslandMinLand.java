package bmps.com.dsa.graphs;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphIslandMinLand {

    public static void main(String[] args) {
        String[][] graph = new String[][] {
                {"W", "L", "W", "W", "L", "W"},
                {"L", "L", "W", "W", "L", "W"},
                {"W", "L", "W", "W", "W", "W"},
                {"W", "W", "W", "L", "L", "W"},
                {"W", "L", "L", "L", "L", "W"},
                {"W", "W", "W", "W", "W", "W"}
        };

        int min = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();

        for (int row = 0; row < graph.length; row++) {
            for (int col = 0; col < graph[0].length; col++) {
                var res = find(graph, row, col, visited);
                if (res > 0 && res < min) min = res;
            }
        }
        
        System.out.println(min);
    }


    /*
        {"W", "L", "W", "W", "L", "W"},
        {"L", "L", "W", "W", "L", "W"},
        {"W", "L", "W", "W", "W", "W"},
        {"W", "W", "W", "L", "L", "W"},
        {"W", "L", "W", "L", "L", "W"},
        {"W", "W", "W", "W", "W", "W"}
     */
    private static int find(String[][] graph, int row, int col, Set<String> visited) {
        var isRowInbound = 0 <= row && row < graph.length;
        var isColsInbound = 0 <= col && col < graph.length;
        if (!isRowInbound || !isColsInbound) return 0;

        if ("W".equals(graph[row][col])) return 0;

        var key = row + "," + col;
        if (visited.contains(key)) return 0;

        visited.add(key);

        int size = 1;
        size += find(graph, row + 1, col, visited);
        size += find(graph, row - 1, col, visited);
        size += find(graph, row, col + 1, visited);
        size += find(graph, row, col - 1, visited);
        return size;
    }
}
