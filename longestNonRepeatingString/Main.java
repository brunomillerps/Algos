package longestNonRepeatingString;

public class Main {
    public static void main(String[] args) {
        var givenString = "abccabcd";

        var start = System.nanoTime();
        lengthLongestNonRepeatedString(givenString);
        var end = System.nanoTime();
        System.out.println("Duration in nano " + ((end - start)));
    }

    private static void lengthLongestNonRepeatedString(String givenString) {
    
        var max = 0;
        for (int right = 0, left = 0; right < givenString.length(); right++) {
            var idxOfFirstAppearenceInSubstring = givenString.indexOf(givenString.charAt(right), left);
            if (idxOfFirstAppearenceInSubstring != right) {
                left = idxOfFirstAppearenceInSubstring + 1;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}