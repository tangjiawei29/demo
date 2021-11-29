package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class L762PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int left, int right) {

        // HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int[] arr = new int[] {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        int cnt = 0;
        for (int i = left; i <= right; i++) {
//            int prime = 0;
//
//            for (int j = i; j > 0; j>>=1) {
//               prime += j&1;
//            }
            if (arr[Integer.bitCount(i)] == 1)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        L762PrimeNumberOfSetBitsInBinaryRepresentation l = new
                L762PrimeNumberOfSetBitsInBinaryRepresentation();
        System.out.println(l.countPrimeSetBits(6, 10));
    }
}
