// https://leetcode.com/problems/binary-tree-maximum-path-sum
// LC124. Binary Tree Maximum Path Sum
// Quadratic time, linear extra-space.
class BinaryTreeMaximumPathSum {
    int maxDepth(TreeNode root) {
        if (root == null) { return 0; }
        int max = root.val +
            Math.max(maxDepth(root.left), maxDepth(root.right));
        return Math.max(max, 0);
    }
    public int maxPathSum(TreeNode root) {
        if (root == null) { return 0; }
        int max = Integer.MIN_VALUE;
        if (root.left != null) {
            max = Math.max(max, maxPathSum(root.left));
        }
        if (root.right != null) {
            max = Math.max(max, maxPathSum(root.right));
        }
        int maxViaRoot = maxDepth(root.left) + maxDepth(root.right) + root.val;
        return Math.max(max, maxViaRoot);
    }
}
