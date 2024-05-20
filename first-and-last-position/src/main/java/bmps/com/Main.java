package bmps.com;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        List<Integer> arr = List.of(1,2,4,5,5,5,5,5,7,8);
        int target = 5;
        int[] pos = new int[2];
        pos[0] = -1;
        pos[1] = -1;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == target) {
                if (pos[0] < 0) {
                    pos[0] = i;
                }

                pos[1] = i;
                if (arr.get(i+1) != target) {
                    break;
                }
            }
        }

        System.out.println("Start at: " + pos[0] + " end: " + pos[1]);
    }
}