package bmps.com.dsa.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] els = {1, 2};

        System.out.println(Arrays.toString(topKFrequent(els, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> elements = new ArrayList<>(nums.length + 1);

        IntStream.range(0, nums.length+1).forEach(idx -> elements.add(new ArrayList<>()));

        Arrays.sort(nums);

        int numCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i+1 != nums.length && nums[i] == nums[i+1]) {
                numCounter += 1;
            } else if (i-1 >=0 && nums[i-1] == nums[i]) {
                // add element to the list adding up 1 to represent the current element
                elements.get(numCounter + 1).add(nums[i]);
                numCounter = 0;
            } else {
                elements.get(1).add(nums[i]);
            }
        }

        int[] result = new int[k];
        Arrays.fill(result, -1);
        int resIdx = 0;
        for (int i = 0; i < elements.size(); i++) {
            if (result[result.length-1] >= 0) {
                return result;
            }

            if (!elements.get(elements.size() - 1 - i).isEmpty()) {
                result[resIdx] = elements.get(elements.size() - 1 - i).get(0);
                resIdx += 1;
            }
        }

        return result;
    }
}
