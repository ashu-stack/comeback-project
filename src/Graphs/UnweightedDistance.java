package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UnweightedDistance {

   static class Pair{
        int node;
        int dist;

        public  Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{0,3},{3,4},{4,5},{5,6},{6,7},{7,8},{6,8}};
        int v = 9;

        int[] dist = new int[9];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] distance = findDistance(0,7,dist,adj);
        System.out.println(Arrays.toString(distance));



    }

    private static int[] findDistance(int src,int dest, int[] dist, ArrayList<ArrayList<Integer>> adj) {

        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()){
            int node = q.peek();
            //int dis = q.peek().dist;
            q.remove();
            for(Integer it : adj.get(node)){
                //int a = dis + 1;
                if(dist[node]+1 < dist[it]){
                    dist[it] = 1 + dist[node];
                    q.add(it);
                }
            }
        }
        return dist;
    }
}
