package org.example;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class PriceCombination {

    double total = 0.0;
    int availability = -1;
    List<String> features = new ArrayList<>();
    List<Price> combinations = new ArrayList<>();

    public PriceCombination() {
    }

    public PriceCombination(PriceCombination cruPrices, Price price) {
        this.total = cruPrices.total;
        this.availability = cruPrices.availability;
        this.features = cruPrices.features;
        this.combinations = new ArrayList<>(cruPrices.combinations);
        addCombination(price);
    }

    public void addCombination(Price price) {
        combinations.add(price);
        total += price.price();
        availability = (availability == -1) ? price.availability() : Math.min(price.availability(), availability);
    }

}
