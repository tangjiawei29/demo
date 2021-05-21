package sort;

import util.SortUtil;

public class MergeSort {

    public static void mergeSort(int[] arr){
       sort(arr,0,arr.length-1);
    }

    public static void sort(int[] arr, int left, int right) {
        if(left>=right) return;
        int mid = (left+right)/2;
        sort(arr, left, mid);
        sort(arr,mid+1, right);
        merge(arr, left, mid, right);

    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmpArr = new int[right-left+1]; // temp array to store sorted data
        int tmpIdx = 0; // for tmpArr
        int tmpR = mid+1;// right idx
        int tmpL = left,oriL = left;// for copy tmpArr to original array

        //compare and merge
        while(left<=mid && tmpR<=right) {
            if(arr[left] < arr[tmpR]){
                tmpArr[tmpIdx] = arr[left];
                tmpIdx++;
                left++;
            }else {
                tmpArr[tmpIdx] = arr[tmpR];
                tmpIdx++;
                tmpR++;
            }
        }

        //when tmpR>right already, assign left part data
        while(left<=mid) {
            tmpArr[tmpIdx] = arr[left];
            tmpIdx++;
            left++;

        }

        //when left>mid already, assign right part data
        while(tmpR<=right){
            tmpArr[tmpIdx] = arr[tmpR];
            tmpIdx++;
            tmpR++;
        }

        // copy tmpArr to original array
        while (tmpL <= right) {
            arr[tmpL] = tmpArr[tmpL-oriL];
//            System.out.print(arr[tmpL]+"\t");
            tmpL++;
        }

    }

    public static void main(String[] args) {
//       int[] arr = new int[]{3,14,1,45,2,7,5,8,10,41,22};
       int[] arr= new int[]{26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
       SortUtil.swapArrayElement(arr, 1,2);
        SortUtil.printArray(arr);
         mergeSort(arr);

        SortUtil.printArray(arr);
    }
}
