package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {

    public static void main(String[] args) {
        int[][] edges = {{1,0}};
        int v = 2;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i< edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
        }

        int[] indegree = new int[v];
        for(int j=0; j<indegree.length;j++){
            for(Integer it : adj.get(j)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int j=0; j<indegree.length;j++){
            if(indegree[j] == 0) q.add(j);
        }

        int[] topo = new int[v];
        int ind = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            topo[ind++] = node;
            q.remove();
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        for (int i = 0; i < topo.length; i++) {
            System.out.print(topo[i]);
        }
        System.out.println();

        System.out.println(ind == v);
    }
}
