package bmps.com.dsa.easy;

import java.util.*;

public class NumberStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        Map<Integer, Integer> pref = new HashMap<>();
        int res = students.length;

        for (int st : students) {
            pref.putIfAbsent(st, 0);
            pref.merge(st, 1, Integer::sum);
        }

        for (int sandwich : sandwiches) {
            if (pref.containsKey(sandwich) && pref.get(sandwich) > 0) {
                res--;
                pref.merge(sandwich, -1, Integer::sum);
            } else {
                return res;
            }
        }

        return res;
    }

    public int countStudentsArray(int[] students, int[] sandwiches) {
        int[] pref = new int[2];
        for (int s : students) pref[s]++;

        int remaining = sandwiches.length;
        for (int sand : sandwiches) {
            if (pref[sand] == 0) break;
            if (remaining-- == 0) break;
            pref[sand]--;
        }

        return remaining;
    }
}
