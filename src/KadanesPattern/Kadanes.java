package KadanesPattern;

public class Kadanes {
    public static void main(String[] args) {
        int[] arr = {2,3,6,2,7,-10};
        //int maxSum = maxSum(arr);
        int minSum = minSum(arr);
        int maxProduct = maxProduct(arr);
        System.out.println(maxProduct);
    }

    private static int maxProduct(int[] arr) {
        int ans = arr[0];
        int minEnd = arr[0];
        int maxEnd = arr[0];
        for(int i=1; i<arr.length; i++){
            int ch1 = arr[i];
            int ch2 = arr[i] * minEnd;
            int ch3 = arr[i] * maxEnd;
            maxEnd = Math.max(ch1, Math.max(ch2,ch3));
            minEnd = Math.min(ch1, Math.min(ch2,ch3));
            ans = Math.max(ans, Math.max(minEnd,maxEnd));
        }
        return ans;
    }

    private static int minSum(int[] arr) {
        int ans = arr[0];
        int bestEnd = arr[0];
        for(int i=1; i<arr.length; i++){
            int ch1 = arr[i];
            int ch2 = bestEnd + arr[i];

            bestEnd = Math.min(ch1,ch2);
            ans = Math.min(ans, bestEnd);
        }
        return ans;
    }

    private static int maxSum(int[] arr) {
        int ans = arr[0];
        int bestEnd = arr[0];

        for(int i=1;i<arr.length; i++){
            int ch1 = arr[i];
            int ch2 = arr[i] + bestEnd;

            bestEnd = Math.max(ch1,ch2);
            ans = Math.max(bestEnd,ans);
        }

        return ans;
    }


}
