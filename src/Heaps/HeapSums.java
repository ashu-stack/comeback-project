package Heaps;

import java.util.*;

public class HeapSums {
    public static void main(String[] args) {
        int[] arr = {3,3,2,2,4,15,4,20,20,9};
        int[][] points = {{1,3},{-2,2},{5,8},{0,1}};
        int k = 2;

        int[][] closePoints = closestPoints(points, k);
        //List<Integer> kSmallest = kthSmallest(arr,k);
       // List<Integer> kLargest = kthLargest(arr,k);
       // List<Integer> kClosest =  kClosestTo(arr,k,10);
        List<Integer> topKFrequent = topKFrequentElement(arr,k);

        System.out.println(Arrays.deepToString(closePoints));

    }

    private static int[][] closestPoints(int[][] points, int k) {
        PriorityQueue<Point> maxHeaps = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b.dist, a.dist);
        });
        int n = points.length;
        for(int i=0; i<n; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            maxHeaps.add(new Point(dist,x,y));
            if(maxHeaps.size()>k){
                maxHeaps.remove();
            }
        }

        int[][] ans = new int[k][2];
        int ind=0;
        while(!maxHeaps.isEmpty()){
            int x = maxHeaps.peek().x;
            int y = maxHeaps.peek().y;
            ans[ind][0] = x;
            ans[ind][1] = y;
            maxHeaps.remove();
            ind++;
        }
        return ans;
    }

    private static List<Integer> topKFrequentElement(int[] arr, int k) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : arr){
            map.put(a ,map.getOrDefault(a,0) + 1);
        }
        PriorityQueue<Pairs> minHeap = new PriorityQueue<>((a,b) -> {
            int cmp = Integer.compare(a.freq, b.freq);
            if(cmp != 0) return cmp;
            return Integer.compare(a.no, b.no);
        });
        for(var entry : map.entrySet()){
            minHeap.add(new Pairs(entry.getValue(),entry.getKey()));
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }

        while(!minHeap.isEmpty()){
            list.add(minHeap.peek().no);
            minHeap.remove();
        }

        return list;

    }

    public static class Point{
        int dist;
        int x;
        int y;
        public Point(int dist, int x, int y){
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    public static class Pairs{
        int freq;
        int no;
        public Pairs(int freq, int no){
            this.freq = freq;
            this.no = no;
        }

        @Override
        public String toString() {
            return "Pairs{" +
                    "freq=" + freq +
                    ", no=" + no +
                    '}';
        }
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
