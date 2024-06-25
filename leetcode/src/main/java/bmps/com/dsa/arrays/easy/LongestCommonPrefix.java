package bmps.com.dsa.arrays.easy;

import java.util.List;
import java.util.Map;

public class LongestCommonPrefix {

    public String lcp(List<String> strings) {
        var longestCommonString = new StringBuilder();
        int min = Integer.MAX_VALUE;

        for (String s : strings) {
            min = Math.min(min, s.length());
        }

        int i = 0;
        while (i < min) {
            for (String s : strings) {
                if (s.charAt(i) != strings.get(0).charAt(i)) {
                    return  s.substring(0, i);
                }
            }
            i++;
        }

        return strings.get(0).substring(0, min);
    }
}
