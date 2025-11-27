package DynamicProgramming.knapsack;

public class SubsetCount {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int w = 10;
        int n = arr.length;
        int count = subCount(arr,w,n,w);
        System.out.println(count);
    }

    private static int subCount(int[] arr, int w, int n, int sum) {
        if(n==0){
            return 0;
        }
        if(w == 0){
            return 1 + subCount(arr,sum,n-1,sum);
        }
        if(arr[n-1] <= w){
            return subCount(arr,w-arr[n-1], n-1,sum) + subCount(arr, w, n-1, sum);
        }
        else{
            return subCount(arr,w,n-1,sum);
        }


    }
}
