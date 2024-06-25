package bmps.com.dsa.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class RotateArray {
    public List<Integer> rotLeft(List<Integer> a, int d) {
        var newRes = a.subList(d - 1, a.size() - 1);
        newRes.addAll(a.subList(0, d - 1));
        return newRes;
    }

    public List<Integer> rotLeftOneLoop(List<Integer> a, int d) {
        // 1, 2, 3, 4, 5
        // 3, 4, 5, 1, 2
        // _ _ _ _ _
        int[] newArr = new int[a.size()];

        int right = d;
        for (int i = 0; i < a.size() && d < a.size(); i++) {
            if (right > 0) {
                newArr[a.size() - right] = a.get(i);
            }
            newArr[i] = a.get(d);
            d++;
            right--;
        }

        var array = new ArrayList<Integer>();
        for (int i : newArr) {
            array.add(i);
        }

        return array;

    }
}
