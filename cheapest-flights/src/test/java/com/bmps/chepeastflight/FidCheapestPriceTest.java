package com.bmps.chepeastflight;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FidCheapestPriceTest {

    @BeforeAll
    public void setupAll() {
        System.out.println("Setting up for each test");
    }

    @Test
    public void test() {
        FidCheapestPrice fcp = new FidCheapestPrice();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeF = new Node("F");

        nodeA.addEdge(nodeB, 10);
        nodeA.addEdge(nodeC, 80);
        nodeB.addEdge(nodeD, 10);
        nodeC.addEdge(nodeD, 10);
        nodeB.addEdge(nodeF, 900);
        nodeD.addEdge(nodeF, 20);

        fcp.findCheapestFlight(nodeA, nodeF);

        Assertions.assertEquals(40, nodeF.getDistance());
        Assertions.assertEquals(List.of(nodeA, nodeB, nodeD), nodeF.getShortestPath());
    }

    @Test
    public void shouldReturn910Distance() {
        FidCheapestPrice fcp = new FidCheapestPrice();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeF = new Node("F");

        nodeA.addEdge(nodeB, 10);
        nodeA.addEdge(nodeC, 80);
        nodeB.addEdge(nodeD, 10);
        nodeC.addEdge(nodeD, 10);
        nodeB.addEdge(nodeF, 900);
        nodeD.addEdge(nodeF, 20);

        fcp.findCheapestFlight(nodeA, nodeF, 1);

        Assertions.assertEquals(910, nodeF.getDistance());
        Assertions.assertEquals(List.of(nodeA, nodeB), nodeF.getShortestPath());
    }

    @Test
    public void shouldReturn40Distance() {
        FidCheapestPrice fcp = new FidCheapestPrice();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeF = new Node("F");

        nodeA.addEdge(nodeB, 10);
        nodeA.addEdge(nodeC, 80);
        nodeB.addEdge(nodeD, 10);
        nodeC.addEdge(nodeD, 10);
        nodeB.addEdge(nodeF, 900);
        nodeD.addEdge(nodeF, 20);

        fcp.findCheapestFlight(nodeA, nodeF, 2);

        Assertions.assertEquals(40, nodeF.getDistance());
        Assertions.assertEquals(List.of(nodeA, nodeB, nodeD), nodeF.getShortestPath());
    }

    @Test
    public void shouldReturn_910() {
        FidCheapestPrice fcp = new FidCheapestPrice();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeF = new Node("F");

        nodeA.addEdge(nodeB, 10);
        nodeA.addEdge(nodeC, 80);
        nodeB.addEdge(nodeD, 10);
        nodeC.addEdge(nodeD, 10);
        nodeB.addEdge(nodeF, 900);
        nodeD.addEdge(nodeF, 20);

        fcp.findCheapestFlight(nodeA, nodeF, 1);

        Assertions.assertEquals(910, nodeF.getDistance());
        Assertions.assertEquals(List.of(nodeA, nodeB), nodeF.getShortestPath());
    }

    @Test
    public void shouldReturn_10() {
        FidCheapestPrice fcp = new FidCheapestPrice();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeF = new Node("F");

        nodeA.addEdge(nodeB, 10);
        nodeA.addEdge(nodeC, 80);
        nodeB.addEdge(nodeD, 10);
        nodeC.addEdge(nodeD, 10);
        nodeB.addEdge(nodeF, 900);
        nodeD.addEdge(nodeF, 20);
        nodeA.addEdge(nodeF, 10);

        fcp.findCheapestFlight(nodeA, nodeF, 2);

        Assertions.assertEquals(10, nodeF.getDistance());
        Assertions.assertEquals(List.of(nodeA), nodeF.getShortestPath());
    }

    @Test
    public void shouldReturn_3_ACDF() {
        FidCheapestPrice fcp = new FidCheapestPrice();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeF = new Node("F");

        nodeA.addEdge(nodeB, 10);
        nodeA.addEdge(nodeC, 1);
        nodeB.addEdge(nodeD, 10);
        nodeC.addEdge(nodeD, 1);
        nodeB.addEdge(nodeF, 900);
        nodeD.addEdge(nodeF, 1);
        nodeA.addEdge(nodeF, 10);

        fcp.findCheapestFlight(nodeA, nodeF, 5);

        Assertions.assertEquals(3, nodeF.getDistance());
        Assertions.assertEquals(List.of(nodeA, nodeC, nodeD), nodeF.getShortestPath());
    }
}
