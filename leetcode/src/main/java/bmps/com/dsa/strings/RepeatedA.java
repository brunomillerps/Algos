package bmps.com.dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class RepeatedA {

    public long repeatedString(String s, long n) {
        long countA = 0;
        for(String a : s.split("")) if (a.equals("a")) countA++;

        long completeRepetitions = n / s.length();
        long remainderLength = n % s.length();

        long totalAs = completeRepetitions * countA;
        for (int i = 0; i < remainderLength; i++) {
            if (s.charAt(i) == 'a') {
                totalAs++;
            }
        }
        return totalAs;
    }
}
