package bmps.com.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given the root of a binary tree, return the level order traversal of its nodes' values.
    (i.e., from left to right, level by level).


    Example 1:
    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[9,20],[15,7]]

    Example 2:
    Input: root = [1]
    Output: [[1]]

    Example 3:
    Input: root = []
    Output: []


    Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000

 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(12);

        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        System.out.println(getTreeLevels(root));
    }

    private static List<List<Integer>> getTreeLevels(TreeNode root) {
        var result = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var level = new ArrayList<Integer>();
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                var curNode = queue.poll();
                if (curNode != null) {
                    level.add(curNode.val);
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }
            }
            if (!level.isEmpty()) result.add(level);
        }

        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
