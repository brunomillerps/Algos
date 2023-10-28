package br.com.bmps.topsort.indegree;

import static java.util.Comparator.reverseOrder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class InDegree2 {

    private final Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private final Map<String, Integer> inDegree = new HashMap<>();

    public List<String> getSorted(String[][] dependencies) {

        for (String[] dependency : dependencies) {
            graph
                .computeIfAbsent(dependency[0], v -> new PriorityQueue<>(reverseOrder()))
                .add(dependency[1]);

            inDegree.putIfAbsent(dependency[0], 0); // from
            inDegree.putIfAbsent(dependency[1], 0); // to

            inDegree.merge(dependency[1], 1, Integer::sum);
        }

        Queue<String> queue = new PriorityQueue<>(reverseOrder());
        for (var it : inDegree.entrySet()) {
            if (it.getValue() == 0) {
                queue.offer(it.getKey());
            }
        }

        LinkedList<String> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            var from = queue.poll();

            result.addFirst(from);

            for (var dest : graph.getOrDefault(from, new PriorityQueue<>())) {
                if (inDegree.get(dest) > 0) {
                    inDegree.merge(dest, -1, Integer::sum);
                    if (inDegree.get(dest) == 0) {
                        queue.offer(dest);
                    }
                }
            }
        }
        return result;
    }

}
