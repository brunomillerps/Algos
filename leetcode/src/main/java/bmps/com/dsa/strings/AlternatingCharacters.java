package bmps.com.dsa.strings;

/*
You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

Example AABAAB

Remove an  at positions  and  to make ABAB in  deletions.


 */
public class AlternatingCharacters {
    public int alternatingCharacters(String s) {
        // Write your code here
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i+1 < s.length() && s.charAt(i+1) == s.charAt(i)) total++;
        }

        return total;
    }
}

