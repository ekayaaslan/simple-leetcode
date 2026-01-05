
// https://leetcode.com/problems/clone-graph
// LC133. Clone Graph
// Linearish time, linearish extra-space.
class CloneGraph {
    public Node cloneThrough(Node node, Map<Node, Node> clones) {
        if (clones.containsKey(node)) { return clones.get(node); }
        Node clone = new Node(node.val);
        clones.put(node, clone);
        for (Node neighbor : node.neighbors) {
            Node cloneOfNeighbor = cloneThrough(neighbor, clones);
            clone.neighbors.add(cloneOfNeighbor);
        }
        return clone;
    }
    public Node cloneGraph(Node node) {
        if (node == null) { return null;}
        Map<Node, Node> clones = new HashMap();
        return cloneThrough(node, clones);
    }
}