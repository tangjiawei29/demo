package leetcode;

public class L134GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;

        while(i < n) {
            int remain = gas[i];
            int j = i;
            while(remain - cost[j] >= 0) {
                remain = remain + gas[(j + 1) % n] - cost[j];
                j = (j + 1) % n;
                if (i == j) return i;
            }
            if (j < i) return -1;//一圈走完,j没有到i
            i = j + 1;//如果i不能到j,那么i+1也不能到j,下次直接从j+1开始.
        }
        return -1;
    }
}
