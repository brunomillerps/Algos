package com.bmps.shortestpath;

import java.util.*;

public class Graph {
    public void calculateShortestPath(Node source) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getDistance));

        source.setDistance(0);
        queue.add(source);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            if (!visited.contains(currNode)) {
                visited.add(currNode);
            }

            currNode.getAdjacentNodes().entrySet().stream()
                    .filter(e -> !visited.contains(e.getKey()))
                    .forEach(e -> {
                        this.evaluateDistanceAndPath(e.getKey(), e.getValue(), currNode);
                        queue.add(e.getKey());
                    });
        }
    }

    private void evaluateDistanceAndPath(Node neighbour, Integer edgeDistance, Node parentNode) {
        var newDistance = parentNode.getDistance() + edgeDistance;

        if (newDistance < neighbour.getDistance()) {
            var shortestPath = new LinkedList<>(parentNode.getShortestPath());
            shortestPath.add(parentNode);

            neighbour.setDistance(newDistance);
            neighbour.setShortestPath(shortestPath);
        }
    }
}
