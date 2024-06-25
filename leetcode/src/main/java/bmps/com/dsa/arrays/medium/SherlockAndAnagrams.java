package bmps.com.dsa.arrays.medium;

import java.util.*;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {
    public int sherlockAndAnagrams(String s) {
        // DOESNT WORK
        Map<String, Integer> anagrams = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String newS = Arrays.stream(s.substring(i,j).split("")).sorted().collect(Collectors.joining());
                anagrams.putIfAbsent(newS, 0);
                anagrams.merge(newS, 1, Integer::sum);
            }
        }

        // Calculate the number of anagrammatic pairs
        int anagrammaticPairs = 0;
        for (Map.Entry<String, Integer> entry : anagrams.entrySet()) {
            int cur = entry.getValue();
            anagrammaticPairs += (cur * (cur - 1)) / 2;
        }

        return anagrammaticPairs;
    }
}
