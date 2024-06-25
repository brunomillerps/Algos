package bmps.com.dsa.trees;

import java.util.*;

public class TreeMazeBacktracking {

    /*
        this solution is using backtracking and DFS to find if there is a valid path in the tree (maze)
        Conditions: 1) the path cannot contain value zero (they are represented as walls or barrie)
                    2) when the node itself is null, means you reached the "outbounds" of the maze, therefore, it must go back
                    3) if the left and right node are null, means you reached a valid path or the leaf, then return true

         We are using a stack to track the valid path in the maze/tree.
            we add the value to the path when condition 1 and 2 are met.
            we pop the element if that path was not valid
     */

    public static void main(String[] args) {
        System.out.println("Hello world!");
        var head = new TreeNode(4);
        var node0 = new TreeNode(0);
        var node1 = new TreeNode(1);
        var node2 = new TreeNode(2);
        var node0_1 = new TreeNode(0);
        var node7 = new TreeNode(7);

        head.left = node0;
        node0.right = node7;

        head.right = node1;
        node1.left = node2;
        node1.right = node0_1;

        Stack<Integer> path = new Stack<>();

        System.out.println(pathExists(head, path));
    }

    public static boolean pathExists(TreeNode node, Stack<Integer> path) {
        if (node == null || node.val == 0) {
            return false;
        }

//        path.push(node.val);

        if (node.left == null && node.right == null) {
            return true;
        }

        if (pathExists(node.left, path)) {
            return true;
        }

        if (pathExists(node.right, path)) {
            return true;
        }

//        path.pop();

        return false;
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
