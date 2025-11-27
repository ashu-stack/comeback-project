package Graphs;

import java.util.*;

public class Dijkstras {

    static class Pair{
        int wt;
        int node;
        public Pair(int wt, int node ) {
            this.wt = wt;
            this.node = node;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1,4}, {0,2,4}, {1,2,2}, {2,3,3}, {2,4,1}, {2,5,6}, {3,5,2}, {4,5,3}};
        int n = 6;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        int[] ans = dijkstrasSet(n, adj, 0);
        System.out.println(Arrays.toString(ans));


    }

    private static int[] dijkstrasSet(int n, ArrayList<ArrayList<Pair>> adj, int src){
        TreeSet<Pair> set = new TreeSet<>((p1,p2) -> p1.wt == p2.wt? p1.node- p2.node : p1.wt-p2.wt);
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        set.add(new Pair(0,src));
        while(!set.isEmpty()){
            Pair curr = set.pollFirst();
            for(Pair arr : adj.get(curr.node)){
                int nbr = arr.node;
                int wt = arr.wt;
                int newDist = curr.wt + wt;

                if(newDist < dist[nbr]){
                    set.add(new Pair(newDist,nbr));
                    if(dist[nbr] < Integer.MAX_VALUE){
                        set.remove(new Pair(dist[nbr], nbr));
                    }
                    dist[nbr] = newDist;
                }
            }
        }

        return dist;
    }

    private static int[] dijkstras(int n, ArrayList<ArrayList<Pair>> adj, int src) {
        // min heap decln
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Comparator.comparingInt(x -> x.wt));
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        dist[src] = 0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty()){
            int wt = pq.peek().wt;
            int node = pq.peek().node;
            pq.remove();
            for(int i=0; i<adj.get(node).size(); i++){
                 int edgeWeight = adj.get(node).get(i).wt;
                 int adjNode = adj.get(node).get(i).node;
                 if(wt+edgeWeight < dist[adjNode]){
                     dist[adjNode] = wt + edgeWeight;
                     pq.add(new Pair(dist[adjNode], adjNode));
                 }
            }
        }
        return dist;
    }

}
