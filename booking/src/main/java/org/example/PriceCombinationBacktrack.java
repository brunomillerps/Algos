package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PriceCombinationBacktrack {

    private static final Map<Integer, List<Price>> dataset = new HashMap<>();
    public static void main(String[] args) throws JsonProcessingException {

        findPrices(176, 179, List.of("breakfast"), 1);
    }

    private static void findPrices(int checkin, int checkout, List<String> features, int nRooms) throws JsonProcessingException {

        Price day176 = new Price(176, 120.0, List.of("breakfast", "refundable"), 5);
        Price day177 = new Price(177, 120.0, List.of("breakfast", "refundable"), 1);
        Price day1771 = new Price(177, 130.0, List.of("breakfast", "wifi"), 3);
        Price day1772 = new Price(177, 150.0, List.of("breakfast", "refundable", "wifi"), 7);
        Price day178 = new Price(178, 100.0, List.of("breakfast", "refundable", "wifi"), 1);

        dataset.put(176, new ArrayList<>(List.of(day176)));
        dataset.put(177, new ArrayList<>(List.of(day177, day1771, day1772)));
        dataset.put(178, new ArrayList<>(List.of(day178)));

        List<PriceCombination> solution = new ArrayList<>();

        var days = IntStream.range(checkin, checkout).boxed().collect(Collectors.toList());

        backtrack(0, new PriceCombination(), solution, days);

        System.out.println(new ObjectMapper().writeValueAsString(solution));
    }

    public static void backtrack(int i, PriceCombination cruPrices, List<PriceCombination> solution, List<Integer> days) {

        if (cruPrices.combinations.size() == days.size()) {
            solution.add(cruPrices);
            return;
        }

        for(var price : dataset.get(days.get(i))) {
            backtrack(i + 1, new PriceCombination(cruPrices, price), solution, days);
        }
    }
}










