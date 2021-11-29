package leetcode;

import java.util.Arrays;

public class L1399CountLargestGroup {
    public int countLargestGroup(int n) {
        int[] arr = new int[36];
        int maxSize = 0;
        int res = 0;
        for(int i=1;i<=n;i++){
            int sum = getNumDigitsSum(i);
            arr[sum-1]++;

            if(maxSize < arr[sum-1]){
                maxSize = arr[sum-1];
                res=1;
            }else if(maxSize == arr[sum-1]){
                res++;
            }
        }

        return  res;
    }

    private int getNumDigitsSum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        L1399CountLargestGroup l = new L1399CountLargestGroup();
        System.out.println(l.countLargestGroup(13));
        System.out.println(l.countLargestGroup(2));
        System.out.println(l.countLargestGroup(15));
        System.out.println(l.countLargestGroup(24));
    }
}
