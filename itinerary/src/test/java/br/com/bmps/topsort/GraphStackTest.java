package br.com.bmps.topsort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class GraphStackTest {

    @Test
    void test() {
        // Create a graph given in the above diagram
        GraphStack g = new GraphStack(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        var result = g.topologicalSort();

        assertEquals(List.of(5, 4, 2, 3, 1, 0), result);
    }
}