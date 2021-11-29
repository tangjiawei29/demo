package leetcode;

public class L1375BulbSwitcherIII {
    public int numTimesAllBlue(int[] light) {
        //可全亮蓝色的时刻= 当前最大亮灯idx==已亮灯数
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
