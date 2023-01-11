package com.bmps.shortestpath;

import java.util.*;

public class Graph {

    public void calculateShortestPath(Node source) {
        source.setDistance(0);
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            var currNode = queue.poll();
            if (!visited.contains(currNode)) {
                visited.add(currNode);
                System.out.println("do something when visiting a node!");
            }

            currNode.getAdjacentNodes()
                    .entrySet().stream()
                    .filter(e -> !visited.contains(e.getKey()))
                    .forEach(e -> {
                        this.evaluateDistanceAndPath(e.getKey(), e.getValue(), currNode);
                        visited.add(e.getKey());
                    });
        }
    }

    private void evaluateDistanceAndPath(Node neighborNode, Integer edgeWeight, Node parentNode) {
        int newDistance = parentNode.getDistance() + edgeWeight;
        if (newDistance < neighborNode.getDistance()) {
            var prevPath = new ArrayList<>(parentNode.getShortestPath());
            prevPath.add(parentNode);

            neighborNode.setDistance(newDistance);
            neighborNode.setShortestPath(prevPath);
        }
    }
}
