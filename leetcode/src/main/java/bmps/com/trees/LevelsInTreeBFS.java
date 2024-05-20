package bmps.com.trees;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelsInTreeBFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println(levels(root));

    }

    public static int levels(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        int levels = 0;
        while (!queue.isEmpty()) {

            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);

            }
            levels++;
        }


        return levels;
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

