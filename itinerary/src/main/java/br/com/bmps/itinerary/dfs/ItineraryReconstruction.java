package br.com.bmps.itinerary.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ItineraryReconstruction {

    public List<String> findItinerary(List<List<String>> tickets, String from) {

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (var ticket : tickets) {
            var departure = ticket.get(0);
            var arrives = ticket.get(1);

            graph
                .computeIfAbsent(departure, v -> new PriorityQueue<>())
                .add(arrives);
        }

        var itinerary = new LinkedList<String>();

        dfs(from, graph, itinerary);

        return itinerary;
    }

    private void dfs(String from, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {

        var arrivals = graph.get(from);

        while (arrivals != null && !arrivals.isEmpty()) {
            var arriveTo = arrivals.poll();
            dfs(arriveTo, graph, itinerary);
        }

        itinerary.addFirst(from);
    }
}
