package bmps.com.dsa.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MaxArraySum {

    public int maxSubsetSumDP(List<Integer> arr) {

        int[] dp = new int[arr.size()];
        dp[0] = Math.max(0, arr.get(0));
        dp[1] = Math.max(dp[0], arr.get(1));

        for (int i = 2; i < arr.size(); i++) {
            dp[i] = Math.max(dp[i-1], arr.get(i) + dp[i-2]);
        }

        return dp[arr.size()-1];
    }

    public int maxSubsetSumLoop(List<Integer> arr) {
        int maxSub = arr.get(0);
        int curSum = 0;

        for (Integer n : arr) {
            if (curSum < 0) {
                curSum = 0;
            }

            curSum += n;
            maxSub = Math.max(curSum, maxSub);
        }

        return maxSub;
    }
}
