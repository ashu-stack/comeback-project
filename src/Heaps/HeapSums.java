package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class HeapSums {
    public static void main(String[] args) {
        int[] arr = {3,2,1,10,11,15,4,20,60,9};
        int k = 4;
        //List<Integer> kSmallest = kthSmallest(arr,k);
       // List<Integer> kLargest = kthLargest(arr,k);
        List<Integer> kClosest =  kClosestTo(arr,k,10);

        System.out.println(kClosest);
    }

    public static class Pair{
        int diff;
        int no;
        public Pair(int diff, int no){
            this.diff = diff;
            this.no = no;
        }
    }
    private static List<Integer> kClosestTo(int[] arr, int k, int origin) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) ->{
            return Integer.compare(b.diff, a.diff) ;
        });
        for(int i=0; i< arr.length; i++){
            int diff = Math.abs(arr[i] - origin);
            maxHeap.add(new Pair(diff, arr[i]));
            if(maxHeap.size()>k){
                maxHeap.remove();
            }
        }
        while(!maxHeap.isEmpty()){
            int a = maxHeap.peek().no;
            list.add(a);
            maxHeap.remove();
        }

        return list;
    }


    private static List<Integer> kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            minHeap.add(arr[i]);
            if(minHeap.size()> k){
                minHeap.remove();
            }
        }
        while(!minHeap.isEmpty()){
            int a = minHeap.peek();
            minHeap.remove();
            list.add(a);
        }
        return list;
    }

    private static List<Integer> kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<arr.length; i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        List<Integer> list = new ArrayList<>();
        int n = maxHeap.size();
        while(!maxHeap.isEmpty()){
            int a = maxHeap.peek();
            list.add(a);
            maxHeap.remove();
        }
        return list;
    }
}
