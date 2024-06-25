package bmps.com.dsa.trees;

import java.util.Map;

public class BinaryTreeHeight {

    private TreeNode<Integer> insertNode(TreeNode<Integer> root, int data) {
        if (root == null) return new TreeNode<>(data);

        if (data <= root.val) {
            root.left = insertNode(root.left, data);
        } else {
            root.right = insertNode(root.right, data);
        }

        return root;
    }

    public TreeNode<Integer> buildTree(String nodes) {
        var strNodes = nodes.split(" ");
        TreeNode<Integer> root = null;
        for (String strNode : strNodes) {
            int data = Integer.parseInt(strNode);
            root = insertNode(root, data);
        }

        // Example:
        int height = getHeight(root);
        System.out.println(height);

        return root;

    }

    public int getHeight(TreeNode<Integer> root) {
        if (root == null) return -1;

        int right = getHeight(root.right);
        int left = getHeight(root.left);

        return Math.max(left, right) + 1;
    }
}
