package sort;

import util.SortUtil;

public class HeapSort {
    public void heapSort(int[] arr){
        int arrLen = arr.length;
        int largestIdx= arrLen-1;
        int startIdx = arrLen/2 -1;
        for (int i = startIdx; i >=0 ; i--) {
            maxHeapify(arr, i, largestIdx);
        }

        for (int i = largestIdx; i >=0; i--) {
            SortUtil.swapArrayElement(arr, 0, i);
            maxHeapify(arr,0,i-1);
        }
    }

    public void maxHeapify(int[] arr, int startIdx, int largestIdx){
        if(startIdx<=largestIdx) {
            int sonLeft = startIdx*2+1;
            int sonRight = startIdx*2+2;
            int tmpIdx = startIdx;
            if(sonLeft <= largestIdx) {
                if (arr[startIdx] < arr[sonLeft]) {
                    startIdx = sonLeft;
                }
            }

            if(sonRight<=largestIdx) {
                if(arr[startIdx] < arr[sonRight]){
                    startIdx = sonRight;
                }
            }
            if(tmpIdx!=startIdx) {
                SortUtil.swapArrayElement(arr, tmpIdx, startIdx);
                maxHeapify(arr, startIdx,largestIdx);
            }

        }
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
//        int[] arr= new int[]{26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
        int[] arr = new int[]{3,14,1,45,2,7,5,8,10,41,22};
        hs.heapSort(arr);

        SortUtil.printArray(arr);
    }
}
