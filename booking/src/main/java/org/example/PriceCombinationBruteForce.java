package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PriceCombinationBruteForce {

    public static void main(String[] args) {

        findPrices(176, 178, List.of("breakfast"), 1);
    }

    private static void findPrices(int checkin, int checkout, List<String> features, int nRooms) {

        Price day176 = new Price(176, 120.0, List.of("breakfast", "refundable"), 5);
        Price day177 = new Price(177, 120.0, List.of("breakfast", "refundable"), 1);
        Price day1771 = new Price(177, 130.0, List.of("breakfast", "wifi"), 3);
        Price day1772 = new Price(177, 150.0, List.of("breakfast", "refundable", "wifi"), 7);

        Map<Integer, List<Price>> dataset = new HashMap<>();
        dataset.put(176, new ArrayList<>(Arrays.asList(day176)));
        dataset.put(177, new ArrayList<>(Arrays.asList(day177, day1771, day1772)));

        List<Price> solution = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        // N * O ^ 2
        for (var day = checkin; day < checkout; day++) {
            seen.add(day);
            for (Price price : dataset.getOrDefault(day, List.of())) {
                if (!price.features().containsAll(features)) {
                    continue;
                }

                if (price.availability() < nRooms) {
                    continue;
                }

                for (var entry2 : dataset.entrySet()) {
                    if (!seen.contains(entry2.getKey())) {
                        for (Price price2 : entry2.getValue()) {

                            if (price2.availability() < nRooms) {
                                continue;
                            }

                            List<String> validFeatures = new ArrayList<>();

                            // merge features
                            for (String feature1 : price.features()) {
                                for (String feature2 : price2.features()) {
                                    if (feature1.equals(feature2)) {
                                        validFeatures.add(feature1);
                                    }
                                }
                            }

                            if (validFeatures.isEmpty()) {
                                continue;
                            }

                            var newPrice = new Price(0, price.price() + price2.price(), validFeatures,
                                                     Math.min(price.availability(), price2.availability()));

                            solution.add(newPrice);
                        }
                    }
                }
            }
        }

        System.out.println(solution);
    }

}










