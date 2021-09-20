

public class LeetCode993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] l = dfs(root, root, 0, x);
        int[] r = dfs(root, root, 0, y);
        return l[1] == r[1] && l[0] != r[0];
    }

    private int[] dfs(TreeNode root, TreeNode father, int depth, int x) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        if (root.val == x) return new int[]{father == root ? 0 : father.val, depth};
        int[] l = dfs(root.left, root, depth + 1, x);
        if (l[0] != -1) return l;
        return dfs(root.right, root, depth + 1, x);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
