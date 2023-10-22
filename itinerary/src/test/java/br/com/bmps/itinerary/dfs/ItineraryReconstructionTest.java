package br.com.bmps.itinerary.dfs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ItineraryReconstructionTest {

    @Test
    void test1() {
        var itinerary = new ItineraryReconstruction();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "SFO"));
        tickets.add(List.of("SFO", "ATL"));
        tickets.add(List.of("ATL", "ORD"));
        tickets.add(List.of("ORD", "JFK"));

        // Expected itinerary: ["JFK", "SFO", "ATL", "ORD"]

        //[[JFK, SFO], [SFO, ATL], [ATL, ORD], [ORD, JFK]]

        var result = itinerary.findItinerary(tickets, "JFK");

        assertEquals(List.of("JFK", "SFO", "ATL", "ORD", "JFK"), result);
    }

    @Test
    void test2() {
        var itinerary = new ItineraryReconstruction();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "SFO"));
        tickets.add(List.of("SFO", "ATL"));
        tickets.add(List.of("ATL", "SFO"));
        tickets.add(List.of("SFO", "ORD"));

        // Expected itinerary: ["JFK", "SFO", "ATL", "SFO", "ORD"]

        var result = itinerary.findItinerary(tickets, "JFK");

        assertEquals(List.of("JFK", "SFO", "ATL", "SFO", "ORD"), result);
    }

    @Test
    void test3() {
        var itinerary = new ItineraryReconstruction();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "ATL"));
        tickets.add(List.of("ATL", "ORD"));
        tickets.add(List.of("ORD", "SFO"));
        tickets.add(List.of("SFO", "JFK"));

        // Expected itinerary: ["JFK", "ATL", "ORD", "SFO"]

        var result = itinerary.findItinerary(tickets, "JFK");

        assertEquals(List.of("JFK", "ATL", "ORD", "SFO", "JFK"), result);
    }

    @Test
    void test4() {
        var itinerary = new ItineraryReconstruction();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "A"));
        tickets.add(List.of("A", "B"));
        tickets.add(List.of("B", "C"));
        tickets.add(List.of("C", "D"));

        // Expected itinerary: ["JFK", "A", "B", "C", "D"]

        var result = itinerary.findItinerary(tickets, "JFK");

        assertEquals(List.of("JFK", "A", "B", "C", "D"), result);
    }

    @Test
    void test5() {
        var itinerary = new ItineraryReconstruction();

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("Chennai", "Banglore"));
        tickets.add(List.of("Bombay", "Delhi"));
        tickets.add(List.of("Goa", "Chennai"));
        tickets.add(List.of("Delhi", "Goa"));

        // Expected itinerary: [Bombay -> Delhi -> Goa -> Chennai -> Banglore]

        var result = itinerary.findItinerary(tickets, "Bombay");

        assertEquals(List.of("Bombay", "Delhi", "Goa", "Chennai", "Banglore"), result);
    }

    @Test
    void test6() {
        List<List<String>> tickets = Arrays.asList(
            Arrays.asList("JFK", "SFO"),
            Arrays.asList("JFK", "ATL"),
            Arrays.asList("SFO", "ATL"),
            Arrays.asList("ATL", "JFK"),
            Arrays.asList("ATL", "SFO")
        );

        var itinerary = new ItineraryReconstruction();

        var result = itinerary.findItinerary(tickets, "JFK");

        var expected = List.of("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");

        Assertions.assertEquals(expected, result);
    }

    @Test
    void test7() {
        List<List<String>> tickets = Arrays.asList(
            Arrays.asList("A", "B"),
            Arrays.asList("A", "C"),
            Arrays.asList("C", "A"));

        var itinerary = new ItineraryReconstruction();

        var result = itinerary.findItinerary(tickets, "A");

        var expected = List.of("A", "C", "A", "B");

        Assertions.assertEquals(expected, result);
    }
}