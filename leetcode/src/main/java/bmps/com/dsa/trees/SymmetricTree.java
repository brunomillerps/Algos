package bmps.com.dsa.trees;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode node1_2 = new TreeNode(2);
        TreeNode node1_8 = new TreeNode(8);
        TreeNode node1_9 = new TreeNode(9);
        TreeNode node1_7 = new TreeNode(7);
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node1_3 = new TreeNode(3);
        TreeNode node1_0 = new TreeNode(0);
        TreeNode node1_6 = new TreeNode(6);


        TreeNode root2 = new TreeNode(5);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode node2_8 = new TreeNode(8);
        TreeNode node2_9 = new TreeNode(9);
        TreeNode node2_7 = new TreeNode(7);
        TreeNode node2_1 = new TreeNode(1);
        TreeNode node2_3 = new TreeNode(3);
        TreeNode node2_0 = new TreeNode(0);
        TreeNode node2_6 = new TreeNode(6);

        root1.left = node1_2;
        root1.right = node1_8;
        node1_2.left = node1_9;
        node1_2.right = node1_7;
        node1_8.left = node1_1;
        node1_9.left = node1_3;
        node1_9.right = node1_0;
        node1_7.right = node1_6;

        root2.right = node2_2;
        root2.left = node2_8;
        node2_2.right = node2_9;
        node2_2.left = node2_7;
        node2_8.right = node2_1;
        node2_9.right = node2_3;
        node2_9.left = node2_0;
        node2_7.left = node2_6;


        System.out.println(isTreesSymmetric(root1, root2));
    }

    private static boolean isTreesSymmetric(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return true;
        if (((root1 == null) != (root2 == null)) || root1.val != root2.val) return false;

        return isTreesSymmetric(root1.left, root2.right) &&
                isTreesSymmetric(root1.right, root2.left);
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

