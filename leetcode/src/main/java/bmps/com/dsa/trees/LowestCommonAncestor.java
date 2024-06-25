package bmps.com.dsa.trees;

public class LowestCommonAncestor extends BinaryTreeHeight {

    public TreeNode<Integer> lca(TreeNode<Integer> root, int v1, int v2) {
        if (root == null) return null;

        if (v1 > v2) {
            int temp = v1;
            v1 = v2;
            v2 = temp;
        }

        if (v1 <= root.val && v2 >= root.val) {
            return root;
        } else if (v1 < root.val && v2 < root.val) {
            return lca(root.left, v1, v2);
        } else {
            return lca(root.right, v1, v2);
        }
    }
}
