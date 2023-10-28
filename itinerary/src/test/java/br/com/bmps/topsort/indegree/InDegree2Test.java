package br.com.bmps.topsort.indegree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InDegree2Test {

    @Test
    void test1() {
        var inDegree2 = new InDegree2();

        var res = inDegree2.getSorted(new String[][]{
            {"A", "B"},
            {"B", "C"},
            {"C", "D"},
            {"B", "F"},
        });

        // A -> B -> C -> D
        //      B -> F

        // D, C, F, B, A

        var expect = List.of("D", "C", "F", "B", "A");

        Assertions.assertEquals(expect, res);
    }

}