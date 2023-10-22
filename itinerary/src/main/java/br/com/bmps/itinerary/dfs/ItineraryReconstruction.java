package br.com.bmps.itinerary.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ItineraryReconstruction {

    public List<String> findItinerary(List<List<String>> tickets, String from) {

        // natural sort the input
        tickets.sort(Comparator
                         .comparing((List<String> airports) -> airports.get(0))
                         .thenComparing(airports -> airports.get(1)));

        Map<String, LinkedList<String>> graph = new HashMap<>();

        for (var ticket : tickets) {
            var departure = ticket.get(0);
            var arrives = ticket.get(1);

            graph.computeIfAbsent(departure, t ->  new LinkedList<>())
                 .add(arrives);
        }

        var result = new ArrayList<String>();

        dfs(graph, from, result);

        Collections.reverse(result);

        return result;
    }

    private void dfs(Map<String, LinkedList<String>> graph, String from, List<String> result) {
        var departures = graph.get(from);

        while (departures != null && !departures.isEmpty()) {
            var to = departures.poll();
            dfs(graph, to, result);
        }

        result.add(from);
    }

}
