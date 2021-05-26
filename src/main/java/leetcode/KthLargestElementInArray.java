package leetcode;

import sort.QuickSort;
import util.SortUtil;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        return qSort(nums,0,nums.length-1, k);
    }
    public int qSort(int[] arr,int startIdx, int endIdx, int k) {

        int partition = getPartition(arr, startIdx, endIdx);

        if(arr.length - partition == k) return arr[partition];
        if(arr.length - partition > k)
            return qSort(arr, partition + 1, endIdx,k);
        return qSort(arr, startIdx, partition-1,k);

    }

    private int getPartition(int[] arr, int startIdx, int endIdx) {

        int pivot= arr[startIdx];
        int left = startIdx;
        int right = endIdx;

        while(true) {
            while(arr[left] < pivot)
                left++;
            while(arr[right] > pivot)
                right--;
            if (left < right)
                SortUtil.swapArrayElement(arr, left, right);
            else
                break;
        }
        if (left > right) SortUtil.swapArrayElement(arr, left, startIdx);
        return left;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{6,5,8,7,4,3,9 };
        KthLargestElementInArray qs = new KthLargestElementInArray();

       int a= qs.qSort(arr,0,arr.length-1,3);
        System.out.println(a);
    }

}
