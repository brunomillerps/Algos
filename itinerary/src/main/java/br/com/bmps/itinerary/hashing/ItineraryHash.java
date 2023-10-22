package br.com.bmps.itinerary.hashing;

import java.util.Map;

public class ItineraryHash {

    private final Map<String, String> itinerary;

    public ItineraryHash(Map<String, String> itinerary) {
        this.itinerary = itinerary;
    }

    public void print() {

        String start = null;

        for (var entry : this.itinerary.entrySet()) {
            if (!this.itinerary.containsValue(entry.getKey())) {
                start = entry.getKey();
                break;
            }
        }

        if (start == null) {
            System.out.print("No start point of your travel, go back and find your ticket!!! =/");
        }

        String to = this.itinerary.get(start);
        while (to != null) {
            System.out.println(start + " -> " + to);
            start = to;
            to = this.itinerary.get(to);
        }
    }
}
