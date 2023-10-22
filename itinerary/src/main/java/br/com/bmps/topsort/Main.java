package br.com.bmps.topsort;

public class Main {

    public static void main(String[] args) {

        // Create a graph given in the above diagram
        GraphStack g = new GraphStack(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                               + "sort of the given graph");
        // Function Call
        var result = g.topologicalSort();
        System.out.println(result);

    }
}