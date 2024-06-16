package bmps.com.arrays;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = new String[] {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };

        System.out.println(printAnagramsGroups(strs));
        System.out.println(anagramsGroupSortedString(strs));
    }

    private static List<List<String>> anagramsGroupSortedString(String[] strs) {

        Map<String, List<String>> mapRes = new HashMap<>();

        for (String str : strs) {
            var charArray = str.toCharArray();
            Arrays.sort(charArray);
            var key = String.valueOf(charArray);
            mapRes.putIfAbsent(key, new ArrayList<>());
            mapRes.get(key).add(str);
        }
        return new ArrayList<>(mapRes.values());
    }

    private static List<List<String>> printAnagramsGroups(String[] strs) {

        Map<String, List<String>> resMap = new HashMap<>();

        for (String str : strs) {
            int[] charCount = new int[26];

            for (int i = 0; i < str.length(); i++) {
                charCount[str.charAt(i) - 'a'] += 1;
            }

            var key = Arrays.toString(charCount);
            resMap.putIfAbsent(key, new ArrayList<>());
            resMap.get(key).add(str);
        }

        return new ArrayList<>(resMap.values());
    }
}
