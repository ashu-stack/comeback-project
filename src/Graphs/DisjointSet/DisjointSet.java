package Graphs.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
   public DisjointSet(int n){
       for (int i = 0; i < n+1; i++) {
           rank.add(0);
           size.add(1);
           parent.add(i);
       }
    }
    public int findPar(int node){
       if(parent.get(node) == node){
           return node;
       }
       else{
           int ultPar  = findPar(parent.get(node));
           parent.set(node,ultPar);
           return ultPar;
       }
    }

    public void unionByRank(int u, int v){
       int ult_u = parent.get(u);
       int ult_v = parent.get(v);
       if(ult_u == ult_v) return;
       if(rank.get(ult_u) < rank.get(ult_v)){
           parent.set(ult_u,ult_v);
       }
       else if(rank.get(ult_v) < rank.get(ult_u)){
           parent.set(ult_v,ult_u);
       }
       else{
           parent.set(ult_u,ult_v);
           int rankU = rank.get(ult_u);
           rank.set(ult_u, rankU+1);
       }
    }

    public void unionBySize(int u, int v){
        int ult_u = parent.get(u);
        int ult_v = parent.get(v);
        if(ult_u == ult_v) return;
        if(size.get(ult_u) < size.get(ult_v)){
            parent.set(ult_u,ult_v);
            size.set(ult_v, size.get(ult_u) + size.get(ult_v));
        }
        else if(size.get(ult_v) < size.get(ult_u)){
            parent.set(ult_v,ult_u);
            size.set(ult_u, size.get(ult_u) + size.get(ult_v));
        }
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(7);
        set.unionByRank(1,2);
        set.unionByRank(3,4);
        set.unionByRank(5,6);
        set.unionByRank(6,7);
        if(set.findPar(6) == set.findPar(5)){
            System.out.println("Same Component");
        }
        else{
            System.out.println("Different Component");
        }
    }

}
