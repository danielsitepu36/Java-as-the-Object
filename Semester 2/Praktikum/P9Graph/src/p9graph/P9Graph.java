package p9graph;

public class P9Graph {
    
    public static void main(String[] args) {
        Graph g = new Graph(6);
        
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        
        g.addEdge(0, 1, 1);
        g.addEdge(0, 2, 1);
        g.addEdge(1, 3, 1);
        g.addEdge(1, 4, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 4, 1);
        g.addEdge(4, 5, 1);
        
        g.bfs(0);
        
    }
    
}
