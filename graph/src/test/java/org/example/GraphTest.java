package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph getGraph() {
        var graph = new Graph();

        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addVertex("Ana");
        graph.addVertex("Jp");

        graph.addVertex("Alan");
        graph.addVertex("Angela");
        graph.addVertex("Maciel");

        graph.addEdge("Angela", "Maciel");
        graph.addEdge("Angela", "Alan");

        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        graph.addEdge("Ana", "Jp");
        return graph;
    }

    @Test
    void shouldTrackPathIndirectGraph() {
        var graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("B", "E");
        graph.addEdge("E", "F");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("F", "D");

        var res = graph.breathFirstTraversal("A");

        System.out.println(res);
    }


    @Test
    void shouldTrackAllPathIndirectGraph() {
        var graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("B", "E");
        graph.addEdge("E", "F");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("F", "D");

        var res = graph.BFSAllDistances("A", "D");

        System.out.println(reconstructPath("A", "D", res.get(0)));
        System.out.println(res);
    }

    @Test
    void shouldTrackAllPathIndirectGraph1() {
        var graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("B1");
        graph.addVertex("B2");
        graph.addVertex("C1");
        graph.addVertex("END");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "B1");
        graph.addEdge("B", "B2");
        graph.addEdge("C", "C1");
        graph.addEdge("B1", "END");
        graph.addEdge("B2", "END");
        graph.addEdge("C1", "END");

        var res = graph.BFSAllDistances("A", "END");

        System.out.println(reconstructPath("A", "END", res.get(0)));
        System.out.println(res);
    }

    private List<String> reconstructPath(String start, String end, Map<String, String> parents) {
        List<String> path = new ArrayList<>();
        for (var at = end; at != null; at = parents.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        if (path.get(0).equals(start)) {
            return path;
        }
        return List.of();
    }

    @Test
    void shouldTrackPathDirectGraph() {
        var graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("B", "E");
        graph.addEdge("E", "F");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");

        var res = graph.breathFirstTraversal("A");

        System.out.println(res);
    }

    @Test
    void shouldReturnDepthFirst() {

        var graph = this.getGraph();

//        assertEquals("[Rob, Bob, Alice, Mark, Maria]", graph.depthFirstTraversal("Rob").toString());
        assertEquals("[Bob, Rob, Alice, Mark, Maria]", graph.depthFirstTraversal("Bob").toString());

//        assertEquals("[Bob, Rob, Alice, Mark, Maria]", graph.breathFirstTraversal("Bob").toString());
//        assertEquals("[Rob, Bob, Alice, Mark, Maria]", graph.breathFirstTraversal("Maria").toString());
//
//        assertTrue(graph.hasPath("Bob", "Mark"));
//        assertTrue(graph.hasPath("Bob", "Bob"));
//        assertTrue(graph.hasPath("Maria", "Mark"));
//        assertFalse(graph.hasPath("JP", "Mark"));
    }

    @Test
    void largestComponent2() {
        var graph = this.getGraph();

        var result = graph.largestComponentBFS();
        assertEquals(5, result);
    }

    @Test
    void connectedComponentsCount() {
        var graph = this.getGraph();

        int connectedNodes = graph.connectedComponentsCount();
        assertEquals(3, connectedNodes);
    }

    @Test
    void largestComponent() {
        var graph = new Graph();

        graph.addVertex("Alan");
        graph.addVertex("Angela");
        graph.addVertex("Maciel");

        graph.addEdge("Angela", "Maciel");

        int result = graph.largestComponentBFS();
        assertEquals(2, result);

        graph.addVertex("Sonia");
        graph.addVertex("Deise");
        graph.addVertex("Kleber");

        graph.addEdge("Sonia", "Deise");
        graph.addEdge("Sonia", "Kleber");

        result = graph.largestComponentBFS();
        assertEquals(3, result);

    }

    @Test
    void binarySearch() {
        var items = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int low = 0, high = items.size() - 1;

        var target = 3;

        while (high - low > 1) {
            int mid = (high + low) / 2;
            if (items.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        assertEquals(items.get(low), target);
    }
}