package com.bmps.chepeastflight;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.Predicate;

public class FidCheapestPrice {

    /**
     * Find the cheapest flight from two points
     * 
     * @param from the start point for the travel
     * @param to is the destination
     */
    public void findCheapestFlight(Node from, Node to) {

        Queue<Node> minQueue = new PriorityQueue<>(Comparator.comparing(Node::getDistance));
        Set<Node> visited = new HashSet<>();

        from.setDistance(0);
        minQueue.add(from);

        while (!minQueue.isEmpty()) {
            Node parentNode = minQueue.poll();

            if (parentNode.equals(to)) {
                break;
            }

            if (visited.contains(parentNode)) {
                continue;
            }

            parentNode.getAdjVertexes().entrySet().stream().filter(onlyNotSeenNodes(visited))
                    .forEach(adjEntry -> {
                        Node neighborNode = adjEntry.getKey();
                        Integer edgeDistance = adjEntry.getValue();

                        int newDistance = parentNode.getDistance() + edgeDistance;
                        if (newDistance < neighborNode.getDistance()) {
                            neighborNode.setDistance(newDistance);

                            List<Node> shortestPath =
                                    new LinkedList<>(parentNode.getShortestPath());

                            shortestPath.add(parentNode);

                            neighborNode.setShortestPath(shortestPath);

                        }
                        minQueue.add(neighborNode);
                    });

            visited.add(parentNode);
        }
    }

    public void findCheapestFlight(Node from, Node to, int numOfStops) {

        Queue<Node> minQueue = new PriorityQueue<>(
                Comparator.comparingInt(Node::getStops).thenComparingInt(Node::getDistance));

        from.setDistance(0);
        from.setStops(0);
        minQueue.add(from);

        while (!minQueue.isEmpty()) {
            Node parentNode = minQueue.poll();

            if (parentNode.equals(to)) {
                break;
            }

            if (parentNode.getStops() == numOfStops + 1) {
                continue;
            }

            parentNode.getAdjVertexes().entrySet().stream().forEach(adjEntry -> {
                Node neighborNode = adjEntry.getKey();
                Integer edgeDistance = adjEntry.getValue();

                int newDistance = parentNode.getDistance() + edgeDistance;
                int newNumStops = parentNode.getStops() + 1;

                if (newNumStops < neighborNode.getStops()
                        || newDistance < neighborNode.getDistance()) {

                    neighborNode.setDistance(newDistance);
                    neighborNode.setStops(newNumStops);

                    List<Node> shortestPath = new LinkedList<>(parentNode.getShortestPath());

                    shortestPath.add(parentNode);
                    neighborNode.setShortestPath(shortestPath);

                }
                minQueue.add(neighborNode);
            });
        }
    }


    public void findCheapestFlightV2(Node from, Node to, int numOfStops) {

        Queue<Node> minQueue = new PriorityQueue<Node>(
                Comparator.comparingInt(Node::getStops).thenComparingInt(Node::getDistance));

        from.setDistance(0);
        from.setStops(numOfStops + 1);
        minQueue.add(from);

        while (!minQueue.isEmpty()) {
            Node parentNode = minQueue.poll();

            if (parentNode.equals(to)) {
                break;
            }

            if (parentNode.getStops() > 0) {

                parentNode.getAdjVertexes().entrySet().stream().forEach(adjEntry -> {
                    Node neighborNode = adjEntry.getKey();
                    Integer edgeDistance = adjEntry.getValue();

                    int newDistance = parentNode.getDistance() + edgeDistance;
                    int newNumStops = parentNode.getStops() - 1;

                    neighborNode.setDistance(newDistance);
                    neighborNode.setStops(newNumStops);

                    List<Node> shortestPath = new LinkedList<>(parentNode.getShortestPath());

                    shortestPath.add(parentNode);
                    neighborNode.setShortestPath(shortestPath);

                    minQueue.add(neighborNode);
                });
            }
        }
    }


    private Predicate<? super Entry<Node, Integer>> onlyNotSeenNodes(Set<Node> visited) {
        return adjEntry -> !visited.contains(adjEntry.getKey());
    }
}
