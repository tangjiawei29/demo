package leetcode;

public class L191Numberof1Bits {
    //O(n)
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += (n >> i) & 1;
        }
        return cnt;
    }


    //O(logn)
    public int hammingWeight2(int n) {
        int cnt =0;
        while(n!=0){
            cnt+= n&1;
            n>>>=1;
            // System.out.println(n);
        }
        return cnt;
    }
}
