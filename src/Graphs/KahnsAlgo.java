package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class KahnsAlgo{
    public static void main(String[] args) {
        int[][] edges = {{5,0}, {4,0}, {4,1}, {3,1}, {2,3},{5,2}};
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }

        int[] indegree = new int[v];
        for(int i=0; i<v; i++){
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q  = new LinkedList<>();
        for(int i=0; i<v; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int ind = 0;
        int[] topo = new int[v];
        while(!q.isEmpty()){
            int node = q.peek();
            topo[ind++] = node;
            q.remove();

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        for (int i = 0; i < v; i++) {
            System.out.print(topo[i] + "  ");
        }






    }
}