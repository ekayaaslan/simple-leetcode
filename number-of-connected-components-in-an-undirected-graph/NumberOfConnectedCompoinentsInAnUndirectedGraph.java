// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
// LC323. Number of Connected Components in an Undirected Graph
class NumberOfConnectedCompoinentsInAnUndirectedGraph {
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
        int components() {
            for (GraphNode node : nodes) { 
                node.visited = false; 
            }
            int count = 0;
            for (GraphNode node: nodes) {
                if (!node.visited) {
                    count ++;
                    visit(node);
                }
            }
            return count;
        }
    }
    public int countComponents(int n, int[][] edges) {
        Graph graph = new Graph(n, edges);
        return graph.components();
    }
}
