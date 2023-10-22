package br.com.bmps.topsort.indegree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InDegreeTest {

    @Test
    public void test() {
        InDegree graph = new InDegree();

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");

        graph.addVertices(a, b);
        graph.addVertices(b, c);
        graph.addVertices(d, a);
        graph.addVertices(d, b);

        Assertions.assertEquals(graph.inDegree.get(a), 1); // D
        Assertions.assertEquals(graph.inDegree.get(b), 2); // A, D
        Assertions.assertEquals(graph.inDegree.get(c), 1); // B
        Assertions.assertEquals(graph.inDegree.get(d), 0);
    }

    @Test
    void should_return_ordered_1() {
        InDegree graph = new InDegree();

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");

        graph.addVertices(a, b);
        graph.addVertices(b, c);
        graph.addVertices(d, a);
        graph.addVertices(d, b);

        // d -> a
        // d -> b -> c
        // a -> b
        Node<String>[] expected = new Node[]{c, b, a, d};

        Node<String>[] result = graph.topSort();
        assertArrayEquals(expected, result);
    }

    @Test
    void should_return_ordered_2_initial_nodes() {
        InDegree graph = new InDegree();

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");

        graph.addVertices(a, b);
        graph.addVertices(b, c);
        graph.addVertices(d, a);
        graph.addVertices(d, b);
        graph.addVertices(e, a);
        graph.addVertices(f, a);

        // d -> a -> b -> c
        // e -> a
        // f -> a
        // d -> b
        Node<String>[] expected = new Node[]{c, b, a, f, e, d};

        Node<String>[] result = graph.topSort();
        assertArrayEquals(expected, result);
    }


    @Test
    void should_return_ordered_1_initial_node() {
        InDegree graph = new InDegree();

        var a = new Node<>("A");
        var b = new Node<>("B");
        var c = new Node<>("C");
        var d = new Node<>("D");
        var e = new Node<>("E");

        graph.addVertices(a, b);
        graph.addVertices(b, c);
        graph.addVertices(c, d);
        graph.addVertices(b, d);
        graph.addVertices(c, e);

        // E D C B A
        Node<String>[] expected = new Node[]{e, d, c, b, a};

        Node<String>[] result = graph.topSort();
        assertArrayEquals(expected, result);
    }


    @Test
    void should_return_ordered_empty_on_cycle() {

        InDegree graph = new InDegree();

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");

        graph.addVertices(a, b);
        graph.addVertices(b, c);
        graph.addVertices(c, d);
        graph.addVertices(b, d);
        graph.addVertices(c, e);
        graph.addVertices(e, a);

        // e -> a -> b -> d
        //           b -> c -> d
        //                c -> e
        //
        Node<String>[] expected = new Node[0];

        Node<String>[] result = graph.topSort();
        assertArrayEquals(expected, result);
    }

    @Test
    void should_return_ordered_mult_start_point() {

        InDegree graph = new InDegree();

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> n = new Node<>("N");
        Node<String> t = new Node<>("T");

        graph.addVertices(a, b);
        graph.addVertices(b, e);
        graph.addVertices(a, n);
        graph.addVertices(f, e);
        graph.addVertices(c, d);
        graph.addVertices(d, t);

        Node<String>[] expected = new Node[]{ e, b, n, a, t, d, c, f };

        Node<String>[] result = graph.topSort();
        assertArrayEquals(expected, result);
    }
}