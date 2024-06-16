package bmps.com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.


Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> ans = new ArrayList<>();

        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int lastEnd = ans.get(ans.size()-1)[1];

            if (intervals[i][0] <= lastEnd) {
                ans.get(ans.size()-1)[1] = Math.max(lastEnd, intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }

        var res = new int[ans.size()][2];

        return ans.toArray(res);
    }

}
