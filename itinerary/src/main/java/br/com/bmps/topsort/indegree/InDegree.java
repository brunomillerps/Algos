package br.com.bmps.topsort.indegree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Topological Sorting using Kahn's BFS Based Algorithm.
 *
 * <p>The approach is based on the fact that a Directed Acyclic Graph (DAG) G has at least one vertex
 * with in-degree 0 and one vertex with out-degree 0.
 *
 * <p><strong>Algorithm:</strong>
 * <ol>
 *   <li>Compute in-degree (number of incoming edges) for each vertex present in the DAG and initialize
 *       the count of visited nodes as 0.</li>
 *   <li>Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation).</li>
 *   <li>Remove a vertex from the queue (Dequeue operation) and then:
 *     <ol type="I">
 *       <li>Increment count of visited nodes by 1.</li>
 *       <li>Decrease in-degree by 1 for all its neighboring nodes.</li>
 *       <li>If in-degree of a neighboring node is reduced to zero, then add it to the queue.</li>
 *     </ol>
 *   </li>
 *   <li>Repeat Step 3 until the queue is empty.</li>
 *   <li>
 *     If count of visited nodes is not equal to the number of nodes in the graph, then the topological
 *     sort is not possible for the given graph.
 *   </li>
 * </ol>
 *
 * <p><strong>How to find in-degree of each node?</strong>
 * <p>There are 2 ways to calculate in-degree of every vertex:
 * <ol>
 *   <li>Take an in-degree array which will keep track of traversing the array of edges and simply
 *       increase the counter of the destination node by 1.</li>
 *   <li>Traverse the list for every node and then increment the in-degree of all the nodes connected
 *       to it by 1.</li>
 * </ol>
 */
public class InDegree {

    final Map<Node<String>, Integer> inDegree = new HashMap<>();

    public void addVertices(Node<String> from, Node<String> to) {

        inDegree.putIfAbsent(from, 0);
        inDegree.putIfAbsent(to, 0);
        // add one incoming edge to the destination node
        inDegree.merge(to, 1, Integer::sum);

        from.addEdge(to);
    }

    public Node<String>[] topSort() {
        Queue<Node<String>> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (var node : inDegree.entrySet()) {
            if (node.getValue() == 0) {
                queue.offer(node.getKey());
            }
        }

        if (queue.isEmpty()) {
            return new Node[0];
        }

        Node<String>[] res = new Node[inDegree.size()];

        int i = inDegree.size() - 1;
        while (!queue.isEmpty()) {
            var curNode = queue.poll();
            res[i] = curNode;
            i--;

            for (var adjacentNode : curNode.getAdjacentNodes()) {
                if (inDegree.get(adjacentNode) > 0) {
                    this.inDegree.merge(adjacentNode, -1, Integer::sum);
                    if (inDegree.get(adjacentNode) == 0) {
                        queue.offer(adjacentNode);
                    }
                }
            }
        }

        return res;
    }
}
