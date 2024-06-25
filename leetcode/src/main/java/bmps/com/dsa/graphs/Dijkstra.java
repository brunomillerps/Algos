package bmps.com.dsa.graphs;

import java.util.*;

/*
Dijkstra's algorithm is used to find the shortest path to all nodes in a weighted graph. It is similar to BFS, except it operates on weighted graphs. Because Dijkstra's algorithm operates on different weights, it will prioritize finding the shortest path such that the path to each destination is the "lightest".

In other words, BFS does not revisit nodes but Dijkstra will, if it finds a shorter path (in terms of weight).

The setup
Suppose we are faced with the following question:

Q: Starting from A, find the length of the shortest path to every other node.
Given the previous weighted graph, and a source vertex, A, we want to find the shortest paths from A to every other vertex in our graph. It should be noted that when we say "shortest", it means "lightest", i.e. paths that have the smallest total weight (the sum of the weight for the edges on the path).

Starting from A, the shortest path to reach C is A -> C, with a weight of 3. And, this is guaranteed to be the shortest path. This makes sense because A -> B costs 10, so even if there was a path to C through B, it would never be less than 4. This only works if we have no negative weights. The visual below demonstrates the graph, edges = [[A,B,10], [A,C,3], [B,D,2], [C,B,4], [C,D,8], [C,E,2], [D,E,5]], and the numbers under the letters denote the shortest path to that vertex.


 */
public class Dijkstra {
    public static void main(String[] args) {

        int[][] edges = new int[][] {
                new int[] {1,2,10},
                new int[] {1,3,3},
                new int[] {2,4,2},
                new int[] {4,2,4},
                new int[] {3,4,8},
                new int[] {3,5,2},
                new int[] {4,5,5}
        };

        System.out.println(shortestPath(edges, 7, 1));
    }

    public static Map<Integer, Integer> shortestPath(int[][] edges, int n, int src) {
        Map<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            // s = src, d = dst, w = weight
            int s = edge[0], dest = edge[1], weight = edge[2];
            adj.putIfAbsent(s, new ArrayList<>());
            adj.get(s).add(new Integer[] {dest, weight});
        }

        Map<Integer, Integer> shortest = new HashMap<>();
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(n2 -> n2[1]));
        minHeap.add(new int[] { src, 0 });

        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int w1 = cur[1], n1 = cur[0];

            if (shortest.containsKey(n1)) {
                continue;
            }
            shortest.put(n1, w1);
            for (Integer[] pair: adj.get(n1)) {
                int n2 = pair[0], w2 = pair[1];
                if (!shortest.containsKey(n2)) {
                    minHeap.add(new int[]{ n2, w1 + w2});
                }
            }
        }
        return shortest;
    }
}
