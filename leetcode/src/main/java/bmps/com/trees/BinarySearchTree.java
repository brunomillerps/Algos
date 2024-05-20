package bmps.com.trees;

public class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.right = new TreeNode(-1);

        System.out.println(exists(233, root));

        System.out.println(height(root));
    }

    public static int height(TreeNode head) {

        if (head == null) {
            return 0;
        }

        if (head.left == null && head.right == null) {
            return 1;
        }

        int leftHeight = 1 + height(head.left);
        int rightHeight = 1 + height(head.right);

        return Math.max(leftHeight, rightHeight);

    }

    public static boolean exists(int target, TreeNode node) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        if (target > node.val) {
            return exists(target, node.right);
        } else {
            return exists(target, node.left);
        }
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

