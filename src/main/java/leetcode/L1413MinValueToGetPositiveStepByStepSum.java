package leetcode;

public class L1413MinValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int minSum = 0x7fffffff;
        int sum = 0;
        for(int i : nums){
            sum+=i;
            minSum = Math.min(sum,minSum);
        }
        return minSum<=0 ? -minSum+1: 1;
    }
}
