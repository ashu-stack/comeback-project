package Graphs;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph{
    public LinkedList<Integer> adjLists[];
    public boolean[] visited;

    Graph(int vertices){
        visited = new boolean[vertices];
        adjLists = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        adjLists[src].add(dest);
        adjLists[dest].add(src);
    }

    public void dfs(int source){
        visited[source] = true;
        System.out.println(source + " ");
        Iterator<Integer> it = adjLists[source].listIterator();
        while(it.hasNext()){
            int adj = it.next();
            if(!visited[adj]){
                dfs(adj);
            }
        }
    }

    public void bfs(int source){
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.offer(source);
        while(!queue.isEmpty()){
            int s = queue.poll();
            System.out.print(s + " ");
            Iterator<Integer> it = adjLists[s].listIterator();
            while(it.hasNext()){
                int n = it.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(3,2);
        graph.addEdge(3,4);
       // graph.bfs(0);
        graph.dfs(0);
    }
}