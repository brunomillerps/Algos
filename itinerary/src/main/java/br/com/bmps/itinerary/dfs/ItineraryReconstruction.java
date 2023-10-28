package br.com.bmps.itinerary.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ItineraryReconstruction {

    public List<String> findItinerary(List<List<String>> tickets, String from) {
        var graph = new HashMap<String, PriorityQueue<String>>();

        for (var ticket : tickets) {
            graph
                .computeIfAbsent(ticket.get(0), d -> new PriorityQueue<>())
                .add(ticket.get(1));
        }

        var result = new ArrayList<String>();

        dfs(from, graph, result);

        Collections.reverse(result);

        return result;
    }

    private void dfs(String from, HashMap<String, PriorityQueue<String>> graph, ArrayList<String> result) {
        var destinations = graph.get(from);

        while (destinations != null && !destinations.isEmpty()) {
            var dest = destinations.poll();
            dfs(dest, graph, result);
        }

        result.add(from);
    }
}
