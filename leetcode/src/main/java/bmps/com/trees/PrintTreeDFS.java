package bmps.com.trees;

import java.util.ArrayList;
import java.util.List;

public class PrintTreeDFS {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        List<Integer> res_inorder = new ArrayList<>();
        List<Integer> res_preorder = new ArrayList<>();
        List<Integer> res_posorder = new ArrayList<>();
        inorder(root, res_inorder);
        preorder(root, res_preorder);
        posorder(root, res_posorder);
        System.out.println(res_inorder);
        System.out.println(res_preorder);
        System.out.println(res_posorder);

    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    private static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    private static void posorder(TreeNode root, List<Integer> result) {
        if (root == null) return;

        preorder(root.left, result);
        preorder(root.right, result);
        result.add(root.val);
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

