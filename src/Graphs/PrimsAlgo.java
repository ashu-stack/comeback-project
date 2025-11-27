package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Pair{
        int dist;
        int node;

        public Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,2}, {0,2,1},{1,2,1},{2,4,1},{2,3,2}};

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        int n = 5;
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        int sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dist - y.dist);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            int wt = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            if(vis[node] == 1) continue;
            vis[node] = 1;
            sum += wt;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).dist;
                int adjNode = adj.get(node).get(i).node;
                if(vis[adjNode] == 0){
                    pq.add(new Pair(edW,adjNode));
                }
            }
        }

        System.out.println(sum);

    }
}
