// https://leetcode.com/problems/binary-tree-level-order-traversal
// LC102. Binary Tree Level Order Traversal
// Linear time, linear extra-space.
class BinaryTreeLevelOrderTraversal {
    List<TreeNode> findNextLevel(List<TreeNode> inLevel) {
        List<TreeNode> nextLevel = new ArrayList();
        for (TreeNode node : inLevel) {
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        return nextLevel;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> values = new ArrayList<List<Integer>>();        
        if (root == null) {
            return values;
        }
        List<List<TreeNode>> nodes = new ArrayList<List<TreeNode>>();        
        List<TreeNode> latestLevel = new ArrayList();
        latestLevel.add(root);
        while (!latestLevel.isEmpty()) {
            nodes.add(latestLevel);
            latestLevel = findNextLevel(latestLevel);
        }

        for (List<TreeNode> nodesOnLevel : nodes) {
            List<Integer> valuesOnLevel = new ArrayList();
            for (TreeNode node : nodesOnLevel) {
                valuesOnLevel.add(node.val);
            }
            values.add(valuesOnLevel);
        }
        return values;
    }
}
