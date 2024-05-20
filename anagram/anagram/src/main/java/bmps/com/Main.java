package bmps.com;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String sentence1 = "nameless";
        String sentence2 = "salesmen";
        Map<Character, Integer> sent1Map = new HashMap<>();
        Map<Character, Integer> sent2Map = new HashMap<>();

        for (int i = 0; i < sentence1.length(); i++) {
            sent1Map.merge(sentence1.charAt(i), 1, Integer::sum);
        }

        for (int i = 0; i < sentence2.length(); i++) {
            sent2Map.merge(sentence2.charAt(i), 1, Integer::sum);
        }

        System.out.println(sent1Map);
        System.out.println(sent2Map);


        List<String> sent1lit = List.of(sentence1.split(""));
        List<String> sent2lit = List.of(sentence2.split(""));

        System.out.println(sent1lit.stream().sorted().collect(Collectors.joining()));
        System.out.println(sent1lit.stream().sorted().collect(Collectors.joining()));


    }
}