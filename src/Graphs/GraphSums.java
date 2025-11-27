package Graphs;

import java.util.*;

public class GraphSums {
    static class Pair{
        int dist;
        int node;

        public Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{5,0},{5,2},{2,3},{3,1},{4,1},{4,0}};
        int n = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] vis = new int[n];
      //  int[] pathvis = new int[n+1];
        Arrays.fill(vis,0);
       // Arrays.fill(pathvis,0);
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i< edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
           // adj.get(v).add(u);
        }

//        boolean ans = checkDfs(1,-1,vis,adj);
//        boolean ansbfs = checkBfs(1,vis,adj);
        int[] ans = kahnsAlgo(n,adj);
        System.out.println(Arrays.toString(ans));
    }

    static int[] dijkstras(int src, int n, int[] vis,  ArrayList<ArrayList<Integer>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        pq.add(new Pair(0,src));
        while(!pq.isEmpty()){
            int dis = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();
            for(int i=0; i<adj.get(node).size(); i++){
                int edW = adj.get(i).get(0);
                int adjNode = adj.get(i).get(1);
                if(dis + edW < dist[adjNode]){
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }

            }
        }
        return dist;
    }

    private static int[] kahnsAlgo(int n, ArrayList<ArrayList<Integer>> adj){
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for(Integer it : adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] topo = new int[n];
        int i=0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            for(Integer it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return topo;

    }
    private static int[] topoSortA(int n, ArrayList<ArrayList<Integer>> adj ) {
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(vis[i] == 0){
                dfs(i,vis,adj,st);
            }
        }
        int[] ans = new int[n];
        int ind = 0;
        while(!st.isEmpty()){
            ans[ind++] = st.peek();
            st.pop();
        }
        return ans;
    }

    private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it,vis,adj,st);
            }

        }
        st.push(node);
    }

    private static boolean directedCycle(int node, int[] vis, int[] pathvis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathvis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                if(directedCycle(it,vis,pathvis,adj) ) return true;
            }
            else if (pathvis[it] == 1){
                return true;
            }
        }
        pathvis[node] = 0;
        return false;
    }

    private static boolean checkBfs(int src, int[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[src] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src,-1));
        while(!q.isEmpty()){
            int node = q.peek().node;
            int parent = q.peek().node;
            q.remove();
            for(Integer adjNode : adj.get(node)){
                if(vis[adjNode] == 0){
                    vis[adjNode] = 1;
                    q.add(new Pair(adjNode,node));
                } else if (adjNode != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDfs(int node,int parent, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                vis[it] = 1;
                if(checkDfs(it,node,vis,adj)) return true;
            }
            else if(it != parent){
                return true;
            }
        }
        return false;
    }


}
