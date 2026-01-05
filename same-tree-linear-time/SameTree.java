// https://leetcode.com/problems/same-tree
// LC100. Same Tree
// Linear time, constant extra-space.
class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) { return true; }
        if (p == null || q == null) { return false; }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
