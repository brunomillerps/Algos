package com.bmps.chepeastflight;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class Node {

    private final String name;
    private int distance = Integer.MAX_VALUE;
    private int stops = Integer.MAX_VALUE;
    private List<Node> shortestPath = new LinkedList<>();
    private Map<Node, Integer> adjVertexes = new HashMap<>();

    public void addEdge(Node to, int distance) {
        adjVertexes.put(to, distance);
    }

    public String toString() {
        return this.name;
    }

    public int hashCode() {
        return this.name.hashCode() + this.distance;
    }
}
