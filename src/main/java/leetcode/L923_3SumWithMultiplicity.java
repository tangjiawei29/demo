package leetcode;

import com.sun.tools.internal.ws.wscompile.WsimportOptions;

import java.util.*;

public class L923_3SumWithMultiplicity {
    public static int threeSumMulti(int[] arr, int target) {

        Arrays.sort(arr);
        int res = 0;

        for (int i = 0; i < arr.length ; i++) {
            int tar = target - arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            while((left < right)) {

                if (arr[left] + arr[right] == tar && arr[left] != arr[right]) {
                    int lt = 1;
                    int rt = 1;

                    while(left +1< right && arr[left] == arr[left + 1]) {
                        left++;
                        lt++;
                    }

                    while(left +1< right && arr[right] == arr[right - 1]) {
                        right--;
                        rt++;
                    }
                    res += lt * rt;
                    res = res % 1_000_000_007;
                    left++;
                    right--;
                } else if (arr[left] + arr[right] == tar && arr[left] == arr[right]) {
                    res+= (right-left+1)*(right-left) / 2;
                    res = res % 1_000_000_007;
                    right--;
                    left++;
                    break;
                } else if (arr[left] + arr[right] < tar) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumMulti(new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
    }
}
