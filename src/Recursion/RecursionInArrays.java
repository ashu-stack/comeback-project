package Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionInArrays {
    public static void main(String[] args) {
        int[] arr = {10,2,2,2,5,6,8};
        List<Integer> list1 = lSearch1(arr, 0,2);
        System.out.println(list1);
//        ArrayList<Integer> list = lSearch1(arr,0,9);
//        System.out.println(list);
//        int ans = binary(arr,12,0, arr.length-1);
//        System.out.println(ans);
    }



    private static int binary(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }
        int mid = (s+e)/2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[s] <= arr[mid]){
            if(arr[s] <= target && target <= arr[mid]){
                return binary(arr,target,s,mid-1);
            }
            else{
                return binary(arr,target, mid+1, e);
            }
        }
        else{
            if(arr[mid] <= target && target <= arr[e]) {
                return binary(arr, target, mid + 1, e);
            }
            return binary(arr,target,s,mid-1);
        }
    }

    public static ArrayList<Integer> list = new ArrayList<>();

    private static ArrayList<Integer> lSearch1 (int[] arr, int ind, int target){
        if(ind == arr.length){
            return list;
        }
        if(arr[ind] == target){
            list.add(ind);
        }
        return lSearch1(arr,ind+1, target);
    }
    private static int lSearch(int[] arr, int ind, int target) {
        if(ind == arr.length){
            return -1;
        }
        if(arr[ind] == target){
            return ind;
        }
            return lSearch(arr, ind+1, target);
    }

    private static boolean isSorted(int[] arr, int ind) {
        if(ind == arr.length-1){
            return true;
        }
        else{
            return ((arr[ind] < arr[ind+1]) && isSorted(arr, ind+1));
        }

    }





}
