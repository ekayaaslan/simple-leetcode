// https://leetcode.com/problems/graph-valid-tree
// LC261. Graph Valid Tree
// Linear time, linear extra-space.
class GraphValidTree {
    class GraphNode {
        List<GraphNode> neighbors;
        boolean visited;
        GraphNode() {
            neighbors = new ArrayList();
            visited = false;
        }
        void add(GraphNode node) {
            neighbors.add(node);
        }
    }
    class Graph {
        GraphNode[] nodes;
        Graph(int n, int[][] edges) {
            nodes = new GraphNode[n];
            for (int i=0; i<n; i++) {
                nodes[i] = new GraphNode();
            }
            int m = edges.length;
            for (int j=0; j<m; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                nodes[u].add(nodes[v]);
                nodes[v].add(nodes[u]);    
            }
        }
        void visit(GraphNode node) {
            if (node.visited) { return; }
            node.visited = true;
            for (GraphNode neighbor : node.neighbors) {
                visit(neighbor);
            }
        }
        boolean connected() {
            for (GraphNode node : nodes) { 
                node.visited = false; 
            }
            visit(nodes[0]);
            for (GraphNode node : nodes) { 
                if (!node.visited) {
                    return false;
                } 
            }
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) { return false; }        
        Graph graph = new Graph(n, edges);
        return graph.connected();
    }
}
