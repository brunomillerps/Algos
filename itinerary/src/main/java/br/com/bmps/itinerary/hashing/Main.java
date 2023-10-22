package br.com.bmps.itinerary.hashing;

import java.util.Map;

public class Main {

    public static void main(String[] args) {

        var itineraryMapping = Map.of(
            "Chennai", "Bangalore",
            "Bombay", "Delhi",
            "Goa", "Chennai",
            "Delhi", "Goa");

        var itineraryOperator = new ItineraryHash(itineraryMapping);

        itineraryOperator.print();
    }
}
