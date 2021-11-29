package leetcode;

import java.util.Arrays;

public class L1338ReduceArraySizetoTheHalf {
    public int minSetSize(int[] arr) {
        int max = 100000;
        int[] a = new int[max+1];
        for(int i:arr){
            a[i]+=1;
        }

        Arrays.sort(a);
        int cnt = 0;
        int sum =0;
        for(int i= max;i>=0;i--){
            if(a[i]>0){
                cnt++;
                sum+=a[i];
                if(sum>=arr.length /2)
                    break;
            }
        }
        return cnt;
    }
}
