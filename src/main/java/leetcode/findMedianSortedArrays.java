package leetcode;

import java.util.Arrays;

public class findMedianSortedArrays {
    public static double func(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length;
        if(lenA > lenB) return func(B,A);
        int totalLen = lenA+lenB;
        int cutA,cutB;
        int startA = 0,endA=lenA;

        while(startA<=endA){
            cutA = (startA+endA)/2;
            cutB = (totalLen+1)/2-cutA;
            double LA = cutA == 0 ?Integer.MIN_VALUE : A[cutA-1];
            double LB = cutB == 0 ?Integer.MIN_VALUE : B[cutB-1];;
            double RA = cutA==lenA?A[cutA-1]:A[cutA];
            double RB = cutB==lenB?B[cutB-1]:B[cutB];
            if(LA>RB){
                endA = cutA-1;
            }else if(LB>RA){
                startA = cutA+1;
            }else{
                return totalLen % 2 == 0 ? (Math.max(LA,LB) + Math.max(RA,RB))/2.0:
                        Math.max(LA,LB);
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[] a = new int[] {2,4,6,7,10};
        int[] b = new int[] {1,3,5,8,9,11,12,13,14};
//        System.out.printf("%s expected=%f%n", func(a, b), 6.5);

        a = new int[] {1, 2};
        b = new int[] {3, 4};
        System.out.printf("%s expected=%s%n", func(a, b), 2.5);
//
        a = new int[] {};
        b = new int[] {1};
        System.out.printf("%s expected=%d%n", func(a, b), 1);

        a = new int[] {1, 3, 4, 5};
        b = new int[] {2, 3, 4, 4};
        System.out.printf("%s expected=%s%n", func(a, b), 3.5);

        a = new int[] {1, 3, 4, 5};
        b = new int[] {2 ,3, 4, 4, 6};
        System.out.printf("%s expected=%d%n", func(a, b), 4);
    }
}
