package bmps.com.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("car", "rat"));
        System.out.println(isAnagramSort("eat", "tea"));
    }

    public static boolean isAnagramSort(String s, String t) {
        var sCharArray = s.toCharArray();
        var tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.toString(sCharArray).equals(Arrays.toString(tCharArray));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            smap.merge(s.charAt(i), 1, Integer::sum);
            tmap.merge(t.charAt(i), 1, Integer::sum);
        }

        for (var sEntry : smap.entrySet()) {
            if ( !sEntry.getValue().equals(tmap.getOrDefault(sEntry.getKey(), -1))) {
                return false;
            }
        }

        return true;
    }
}
