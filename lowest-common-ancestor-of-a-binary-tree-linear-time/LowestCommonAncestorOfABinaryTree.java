// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
// LC236. Lowest Common Ancestor of a Binary Tree
// Linear time, linear extra-space.
class ResultTriplet {
    boolean hasP;
    boolean hasQ;
    TreeNode lca; // not-null iff hasP=true and hasQ=true.
    ResultTriplet(boolean hasP, boolean hasQ) {
        this.hasP = hasP;
        this.hasQ = hasQ;
        this.lca = null;
    }
    ResultTriplet(boolean hasP, boolean hasQ, TreeNode lca) {
        this.hasP = hasP;
        this.hasQ = hasQ;
        this.lca = lca;
    }
}
class LowestCommonAncestorOfABinaryTree {
    // Returns null if node is null.
    ResultTriplet lcaResult(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) { return null; }
        ResultTriplet left = lcaResult(node.left, p, q);
        ResultTriplet right = lcaResult(node.right, p, q);

        if (left == null && right == null) {
            return new ResultTriplet((node == p), (node == q));            
        }
        if (left == null) { // right is not null
            boolean hasP = (node == p) || right.hasP;
            boolean hasQ = (node == q) || right.hasQ;
            if (hasP && hasQ) {
                return new ResultTriplet(hasP, hasQ, right.lca == null? node: right.lca);
            }
            return new ResultTriplet(hasP, hasQ);
        }
        if (right == null) { // left is not null
            boolean hasP = (node == p) || left.hasP;
            boolean hasQ = (node == q) || left.hasQ;
            if (hasP && hasQ) {
                return new ResultTriplet(hasP, hasQ, left.lca == null? node: left.lca);
            }
            return new ResultTriplet(hasP, hasQ);
        }
        
        boolean hasP = (node == p) || left.hasP || right.hasP;
        boolean hasQ = (node == q) || left.hasQ || right.hasQ;
        if (hasP && hasQ) {
            if (left.lca != null) { return new ResultTriplet(hasP, hasQ, left.lca); }
            if (right.lca != null) { return new ResultTriplet(hasP, hasQ, right.lca); }
            return new ResultTriplet(hasP, hasQ, node);
        }
        return new ResultTriplet(hasP, hasQ);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaResult(root, p, q).lca;
    }
}
