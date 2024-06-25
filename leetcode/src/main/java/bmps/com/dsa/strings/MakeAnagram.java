package bmps.com.dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class MakeAnagram {
    public int makeAnagram(String a, String b) {
        // Write your code here
        Map<Character, Integer> chars = new HashMap<>();
        Map<Character, Integer> charsB = new HashMap<>();
        for (Character c : a.toCharArray()) {
            chars.putIfAbsent(c, 0);
            chars.merge(c, 1, Integer::sum);
        }

        for (Character c : b.toCharArray()) {
            charsB.putIfAbsent(c, 0);
            charsB.merge(c, 1, Integer::sum);
        }

        int charDeletionCount = 0;
        for (var entryA: chars.entrySet()) {
            if (!charsB.containsKey(entryA.getKey())) {
                charDeletionCount += entryA.getValue();
            } else {
                charDeletionCount += Math.abs(charsB.get(entryA.getKey()) - entryA.getValue());
                charsB.remove(entryA.getKey());
            }
        }

        for (var entryB: charsB.entrySet()) {
            charDeletionCount += entryB.getValue();
        }


        return charDeletionCount;
    }
}
