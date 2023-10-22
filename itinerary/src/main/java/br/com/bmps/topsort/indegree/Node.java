package br.com.bmps.topsort.indegree;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private final T value;
    private final TreeSet<Node<T>> adjacentNodes;

    public Node(T value) {
        this.value = value;
        this.adjacentNodes = new TreeSet<>();
    }

    public void addEdge(Node<T> to) {
        this.adjacentNodes.add(to);

    }

    public SortedSet<Node<T>> getAdjacentNodes() {
        return this.adjacentNodes;
    }

    public T value() {
        return this.value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Node<?>) {
            return ((Node<?>) other).value.equals(value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int compareTo(Node<T> o) {
        return this
            .value()
            .compareTo(o.value());
    }
}
