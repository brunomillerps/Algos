package bmps.com.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 It is also valid if he can remove just  character at  index in the string, and the remaining
 characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

 */
public class SherlockAndValidString {
    public String isValid(String s) {
        Map<String, Integer> charFrequency = new HashMap<>();
        for (String v : s.split("")) {
            charFrequency.merge(v, 1, Integer::sum);
        }

        Map<Integer, Integer> countFrequency = new HashMap<>();
        for (Integer value : charFrequency.values()) {
            countFrequency.merge(value, 1, Integer::sum);
        }

        if (countFrequency.size() == 1) return "YES";
        if (countFrequency.size() > 2) return "NO";

        int[] freqValues = new int[2];
        int[] countValues = new int[2];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : countFrequency.entrySet()) {
            freqValues[i] = entry.getKey();
            countValues[i] = entry.getValue();
            i++;
        }

        // Check the conditions described
        if ((countValues[0] == 1 && (freqValues[0] - 1 == freqValues[1] || freqValues[0] == 1)) ||
                (countValues[1] == 1 && (freqValues[1] - 1 == freqValues[0] || freqValues[1] == 1))) {
            return "YES";
        }

        return "NO";
    }
}
