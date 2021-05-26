package sort;

import util.SortUtil;

public class QuickSort {
    public void qSort(int[] arr,int startIdx, int endIdx) {
        if(arr.length<2) return;
        if (startIdx < endIdx) {
            int partition = getPartition(arr, startIdx, endIdx);

            qSort(arr, startIdx, partition - 1);
            qSort(arr, partition + 1, endIdx);
        }
    }

    private int getPartition(int[] arr, int startIdx, int endIdx) {
        int pivotIdx = startIdx;
        int pivot= arr[pivotIdx];
        int left = startIdx;
        int right = endIdx;

        while(true) {
            while(arr[left] < pivot)
                left++;
            while(arr[right] > pivot)
                right--;
            if(left<right)
                SortUtil.swapArrayElement(arr, left, right);
            else
                break;
        }
        if (left > right) SortUtil.swapArrayElement(arr, left, pivotIdx);
        return left;
    }

    public static void main(String[] args) {
//        int[] arr= new int[]{26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
        int[] arr= new int[]{6,5,8,7,4,3,9 };
        QuickSort qs = new QuickSort();

        qs.qSort(arr,0,arr.length-1);
        SortUtil.printArray(arr);
    }
}
