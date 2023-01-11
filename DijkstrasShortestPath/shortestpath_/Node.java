package com.bmps.shortestpath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Node implements Comparable<Node> {
    private final String name;
    private Integer distance;
    private List<Node> shortestPath;
    private Map<Node, Integer> adjacentNodes;

    public Node(String name) {
        this.name = name;
        this.shortestPath = new LinkedList<>();
        this.adjacentNodes = new HashMap<>();
    }

    public void addEdge(Node node, int weight) {
        adjacentNodes.put(node, weight);
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance.compareTo(o.distance);
    }
}
