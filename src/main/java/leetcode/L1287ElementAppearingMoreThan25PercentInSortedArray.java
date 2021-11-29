package leetcode;

public class L1287ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int m = arr.length / 4;
        for (int i = 0; i <= arr.length - m; i++) {
            if (arr[i] == arr[i + m]) {
                return arr[i];
            }
        }
        return -1;
    }
}
