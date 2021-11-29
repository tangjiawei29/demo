package leetcode;

public class L565ArrayNesting {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int tmp = nums[j];
                nums[j] = -1;
                j = tmp;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
