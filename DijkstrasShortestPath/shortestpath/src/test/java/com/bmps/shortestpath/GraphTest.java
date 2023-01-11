package com.bmps.shortestpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphTest {

    @Test
    void calculateShortestPath() {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeE = new Node("E");

        nodeA.addEdge(nodeB, 2);
        nodeA.addEdge(nodeC, 1);
        nodeC.addEdge(nodeE, 1);
        nodeE.addEdge(nodeA, 1);

        var graph = new Graph();

        graph.calculateShortestPath(nodeA);

        Assertions.assertEquals("A : 0", nodeA.getPath());
        Assertions.assertEquals("A -> C : 1", nodeC.getPath());
        Assertions.assertEquals("A -> C -> E : 2", nodeE.getPath());
    }
}