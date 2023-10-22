package br.com.bmps.topsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

// This class represents a directed graph
// using adjacency list representation
public class GraphStack {

    private int numOfVertices;

    private ArrayList<ArrayList<Integer>> adjacentNodes;

    public GraphStack(int size) {
        this.numOfVertices = size;
        adjacentNodes = new ArrayList<>(size);
        IntStream
            .range(0, size)
            .forEach(idx -> adjacentNodes.add(new ArrayList<>()));
    }

    public void addEdge(int source, int dest) {
        adjacentNodes
            .get(source)
            .add(dest);
    }

    public ArrayList<Integer> topologicalSort() {
        var result = new ArrayList<Integer>();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[this.numOfVertices];

        // Call the recursive helper function to store
        // Topological Sort starting from all vertices one by one
        for (int i = 0; i < this.numOfVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, result);
            }
        }
        Collections.reverse(result);
        return result;
    }

    private void topologicalSortUtil(int from, boolean[] visited, List<Integer> result) {
        // Mark the current node as visited.
        visited[from] = true;

        // Recur for all the vertices adjacent
        for (var i : adjacentNodes.get(from)) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, result);
            }
        }

        result.add(from);
    }
}
