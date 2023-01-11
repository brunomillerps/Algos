package com.bmps.shortestpath;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Node {
    private final String value;
    private final Map<Node, Integer> adjacentNodes = new HashMap<>();
    private Integer distance = Integer.MAX_VALUE;
    private List<Node> shortestPath = new LinkedList<>();

    public void addEdge(Node neighbour, int distance) {
        this.adjacentNodes.put(neighbour, distance);
    }

    public String toString() {
        return this.value;
    }

    public String getPath() {
        var path = this.shortestPath.stream()
                .map(Node::getValue)
                .collect(Collectors.joining(" -> "));

        return path.isEmpty() ? this.value + " : 0" : path + " -> " + this.value + " : " + this.distance;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

}
