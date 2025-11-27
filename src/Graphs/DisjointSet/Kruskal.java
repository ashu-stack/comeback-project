package Graphs.DisjointSet;

public class Kruskal {
    class Edge implements Comparable<Edge>{
        int src,dest,weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
