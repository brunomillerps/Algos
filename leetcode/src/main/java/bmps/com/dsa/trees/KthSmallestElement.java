package bmps.com.dsa.trees;

public class KthSmallestElement {
    public int kthSmallestElement(TreeNode<Integer> root, int k) {
        int[] ans = new int[]{0};
        int[] count = new int[]{k};
        dfs(root, ans, count);

        return ans[0];
    }

    private void dfs(TreeNode<Integer> root, int[] ans, int[] count) {
        if (root == null) return;

        dfs(root.left, ans, count);

        if (count[0] == 1) {
            ans[0] = root.val;
        }

        count[0] -= 1;

        if (count[0] > 0) {
            dfs(root.right, ans, count);
        }
    }
}
