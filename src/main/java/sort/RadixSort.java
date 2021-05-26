package sort;

import util.SortUtil;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {63, 157, 189, 51, 101, 47, 141, 121, 157, 156,
                194, 117, 98, 139, 67, 133, 181, 12, 28, 0, 109};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    private static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int i = 1; max / i > 0; i *= 10) {
            int[] buckets = new int[10];
            int[] tempArr = new int[arr.length];

            for (int v : arr) {
                buckets[(v / i) % 10]++;
            }
            for (int j = 1; j < buckets.length; j++) {
                buckets[j] += buckets[j - 1];
            }
            for (int k = arr.length - 1; k >= 0; k--) {
                tempArr[buckets[arr[k] / i % 10] - 1] = arr[k];
                buckets[arr[k] / i % 10]--;
            }
            System.arraycopy(tempArr, 0, arr, 0, arr.length);

        }
    }
}