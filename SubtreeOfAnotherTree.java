// https://leetcode.com/problems/subtree-of-another-tree
// LC572. Subtree of Another Tree
// Quadratic time, linear extra-space.
class SubtreeOfAnotherTree {
    boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSame(root, subRoot)) {
            return true;
        }
        if (root == null) { return false; }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
