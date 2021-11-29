package leetcode;

public class L978LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        int[] up = new int[arr.length];
        int[] dn = new int[arr.length];
        up[0] = 1;
        dn[0] = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                up[i] = 1;
                dn[i] = 1;
            } else if (arr[i - 1] < arr[i]) {
                up[i] = dn[i - 1] + 1;
                dn[i] = 1;
            } else {//arr[i-1] > arr[i]
                up[i] = 1;
                dn[i] = up[i - 1] + 1;
            }
            res = Math.max(res, Math.max(up[i], dn[i]));
        }
        return res;
    }
}
