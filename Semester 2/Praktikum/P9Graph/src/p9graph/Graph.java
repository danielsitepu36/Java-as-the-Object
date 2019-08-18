package p9graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {
    String label;
    boolean isVisited;
    
    Vertex(String label){
        this.label=label;
        isVisited = false;
    }
}

public class Graph {
    private Vertex V[];
    private int vMax;
    private int[][] adjMat;
    private int nV;
    private Queue<Integer> q = new LinkedList<>();
    private Stack<Integer> s = new Stack<>();
    final static int INF = Integer.MAX_VALUE;
    
    Graph(int vMax){
        this.vMax = vMax;
        nV = 0;
        V = new Vertex[vMax];
        adjMat = new int[vMax][vMax];
        for(int i=0;i<vMax;i++){
            for(int j=0;j<vMax;j++){
                adjMat[i][j]=0;
            }
        }
    }
    
    public void addVertex(String label){
        V[nV] = new Vertex(label);
        nV++;
    }
    
    public void addEdge(int s, int d, int w){
        adjMat[s][d]=w;
        adjMat[d][s]=w;
    }
    
    public int unVisitedAdjVet(int v){
        for(int i=0;i<nV;i++){
            if(adjMat[i][v]>0 && !V[i].isVisited){
                return i;
            }
        }
        return -1;
    }
    
    public void bfs(int start){
        q.add(start);
        V[start].isVisited=true;
        System.out.println(V[start].label + " ");
        
        while(!q.isEmpty()){
            int vet = unVisitedAdjVet(q.peek());
            
            if(vet==-1){
                q.remove();
            } else {
                V[vet].isVisited=true;
                System.out.println(V[vet].label + " ");
                q.add(vet);
            }
        }
    }
    
    public void dfs(int start){
        s.push(start);
        V[start].isVisited=true;
        System.out.println(V[start].label + " ");
        
        while(!s.isEmpty()){
            int vet = unVisitedAdjVet(s.peek());
            
            if(vet==-1){
                s.pop();
            } else {
                V[vet].isVisited=true;
                System.out.println(V[vet].label + " ");
                s.push(vet);
            }
        }
    }
    
        int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < vMax; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < vMax; i++)
            System.out.println(i+" tt "+dist[i]);
    }

    void dijkstra(int src)
    {
        int graph[][] = adjMat;
        int dist[] = new int[vMax];
        Boolean sptSet[] = new Boolean[vMax];
        for (int i = 0; i < vMax; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < vMax-1; count++)
        {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < vMax; v++)
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        // print the constructed distance array
        printSolution(dist, vMax);
    }

    void floydWarshall()
    {
        int graph[][] = adjMat;
        int dist[][] = new int[vMax][vMax];
        int i, j, k;

        /* Initialize the solution matrix same as input graph matrix.
           Or we can say the initial values of shortest distances
           are based on shortest paths considering no intermediate
           vertex. */
        for (i = 0; i < vMax; i++)
            for (j = 0; j < vMax; j++)
                dist[i][j] = graph[i][j];

        /* Add all vertices one by one to the set of intermediate
           vertices.
          ---> Before start of an iteration, we have shortest
               distances between all pairs of vertices such that
               the shortest distances consider only the vertices in
               set {0, 1, 2, .. k-1} as intermediate vertices.
          ----> After the end of an iteration, vertex no. k is added
                to the set of intermediate vertices and the set
                becomes {0, 1, 2, .. k} */

        for (k = 0; k < vMax; k++)
        {
            // Pick all vertices as source one by one
            for (i = 0; i < vMax; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < vMax; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distance matrix
        printSolutionWarshall(dist);
    }

    void printSolutionWarshall(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<vMax; ++i)
        {
            for (int j=0; j<vMax; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }
    
    
}
