package org.example;

import java.util.*;

record Vertex(String label) {
    static Vertex of(String label) {
        return new Vertex(label);
    }
}


/**
 * There are two possible ways to traverse a graph:
 * - depth-first traversal
 * - breadth-first traversal
 */
class Graph {
    private final Map<Vertex, List<Vertex>> vertices = new HashMap<>();

    void addVertex(String label) {
        this.vertices.putIfAbsent(Vertex.of(label), new ArrayList<>());
    }

    void addEdge(String label1, String label2) {
        var v1 = Vertex.of(label1);
        var v2 = Vertex.of(label2);
        this.vertices.get(v1).add(v2);
        this.vertices.get(v2).add(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return this.vertices.getOrDefault(Vertex.of(label), List.of());
    }


    void findShortestPath(String start, String end) {
        var prev = this.breathFirstTraversal(start);
//        this.reconstructPath(start, end, prev);
    }


    int largestComponentBFS() {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int max = 1;

        for (Vertex node : this.vertices.keySet()) {
            queue.add(node.label());
            visited.add(node.label());
            var nodesCounter = 1;

            new PriorityQueue<Map<String, String>>();

            while (!queue.isEmpty()) {
                max = Math.max(nodesCounter, max);
                var vertex = queue.poll();
                var neighbors = this.getAdjVertices(vertex);

                for (Vertex v : neighbors) {
                    if (!visited.contains(v.label())) {
                        visited.add(v.label());
                        queue.add(v.label());
                        nodesCounter++;
                    }
                }
            }
        }
        return max;
    }

    int connectedComponentsCount() {
        var graphComponents = 0;
        var visited = new HashSet<String>();

        for (Vertex v : this.vertices.keySet()) {
            Queue<String> queue = new LinkedList<>();
            queue.add(v.label());
            if (!visited.contains(v.label())) {
                graphComponents++;
            }
            while (!queue.isEmpty()) {
                visited.add(v.label());
                var vertex = queue.poll();
                for (Vertex neighbors : this.getAdjVertices(vertex)) {
                    if (!visited.contains(neighbors.label())) {
                        visited.add(neighbors.label());
                        queue.add(neighbors.label());
                    }
                }
            }
        }
        return graphComponents;
    }

    Set<String> depthFirstTraversal(String root) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.println(vertex);
            }
            var vertices = this.getAdjVertices(vertex);
            for (Vertex v : vertices) {
                if (!visited.contains(v.label())) {
                    stack.push(v.label());
                }
            }
        }

        return visited;
    }

    // grap, A -> F
    Set<String> breathFirstTraversal(String root) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        Map<String, String> parent = new HashMap<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(root);
                System.out.println(node);
            }
            var neighbours = this.getAdjVertices(node);
            for (Vertex next : neighbours) {
                if (!visited.contains(next.label())) {
                    // add the path taken to the node (backward)
                    parent.put(next.label(), node);
                    visited.add(next.label());
                    queue.add(next.label());
                }
            }
        }

        var numberOfLevels = parent.values().stream().distinct().count();
        System.out.println("Number of visited levels is: " + numberOfLevels);
        return visited;
    }

    List<Map<String, String>> BFSAllDistances(String from, String destination) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        Map<String, String> parent = new HashMap<>();
        List<Map<String, String>> allPaths = new ArrayList<>();

        queue.add(from);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (node.equals(destination)) {
                allPaths.add(parent);
                parent = new HashMap<>();
            }

            if (!visited.contains(node)) {
                visited.add(from);
            }

            var neighbours = this.getAdjVertices(node);
            for (Vertex next : neighbours) {
                if (!visited.contains(next.label())) {
                    // add the path taken to the node (backward)
                    parent.put(next.label(), node);
                    visited.add(next.label());
                    queue.add(next.label());
                }
            }
        }

        return allPaths;
    }


    boolean hasPath(String origin, String destination) {
        if (!this.vertices.containsKey(Vertex.of(origin)) || !this.vertices.containsKey(Vertex.of(destination))) {
            return false;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(origin);

        while (!queue.isEmpty()) {
            var vertex = queue.poll();
            if (vertex.equals(destination)) {
                return true;
            }

            for (Vertex v : this.getAdjVertices(vertex)) {
                queue.add(v.label());
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
    }
}