package bmps.com.dp;

import java.util.*;

public class ApartmentSearch {
    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        blocks.add(Map.of("gym", false, "supermarket", false, "school", true));
        blocks.add(Map.of("gym", true, "supermarket", false, "school", true));
        blocks.add(Map.of("gym", false, "supermarket", true, "school", true));

        List<String> reqs = List.of("school", "supermarket");

        int bestBlock = findBestBlock(blocks, reqs);
        System.out.println("The best block to rent is at index: " + bestBlock);
    }

    public static int findBestBlock(List<Map<String, Boolean>> blocks, List<String> reqs) {
        int numBlocks = blocks.size();
        int numReqs = reqs.size();
        int[][] minDistancesFromBlocks = new int[numReqs][numBlocks];

        // Initialize the distances to infinity
        for (int i = 0; i < numReqs; i++) {
            Arrays.fill(minDistancesFromBlocks[i], Integer.MAX_VALUE);
        }

        // Forward pass to find minimum distances to each required facility
        for (int reqIndex = 0; reqIndex < numReqs; reqIndex++) {
            String req = reqs.get(reqIndex);
            int closestReqIndex = -1;
            for (int i = 0; i < numBlocks; i++) {
                if (blocks.get(i).get(req)) {
                    closestReqIndex = i;
                }
                if (closestReqIndex != -1) {
                    minDistancesFromBlocks[reqIndex][i] = Math.min(minDistancesFromBlocks[reqIndex][i], Math.abs(i - closestReqIndex));
                }
            }
        }

        // Backward pass to find minimum distances to each required facility
        for (int reqIndex = 0; reqIndex < numReqs; reqIndex++) {
            String req = reqs.get(reqIndex);
            int closestReqIndex = -1;
            for (int i = numBlocks - 1; i >= 0; i--) {
                if (blocks.get(i).get(req)) {
                    closestReqIndex = i;
                }
                if (closestReqIndex != -1) {
                    minDistancesFromBlocks[reqIndex][i] = Math.min(minDistancesFromBlocks[reqIndex][i], Math.abs(i - closestReqIndex));
                }
            }
        }

        // Find the block with the minimum maximum distance to any required facility
        int bestBlockIndex = -1;
        int bestBlockMaxDistance = Integer.MAX_VALUE;
        for (int i = 0; i < numBlocks; i++) {
            int maxDistanceToAnyReq = Integer.MIN_VALUE;
            for (int reqIndex = 0; reqIndex < numReqs; reqIndex++) {
                maxDistanceToAnyReq = Math.max(maxDistanceToAnyReq, minDistancesFromBlocks[reqIndex][i]);
            }
            if (maxDistanceToAnyReq < bestBlockMaxDistance) {
                bestBlockMaxDistance = maxDistanceToAnyReq;
                bestBlockIndex = i;
            }
        }

        return bestBlockIndex;
    }
}
