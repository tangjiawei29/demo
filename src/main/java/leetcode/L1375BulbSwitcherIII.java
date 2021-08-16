package leetcode;

public class L1375BulbSwitcherIII {
    public int numTimesAllBlue(int[] light) {
        int res=0;
        int k = 0;
        int cnt = 0;
        for(int i : light) {
            k = Math.max(k,i);
            cnt++;
            if(cnt==k)res++;

        }
        return res;
    }
}
