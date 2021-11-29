package leetcode;

public class L487MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int max = 1;
        int zero = 0;
        while(r < n) {
            if (nums[r] == 0) zero++;
            while(zero > 1) {
                if (nums[l] == 0) zero--;
                l++;
            }
            max = Math.max(r - l + 1, max);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        L487MaxConsecutiveOnesII a = new L487MaxConsecutiveOnesII();
        System.out.println(a.findMaxConsecutiveOnes(new int[] {1, 0, 1, 1, 0}));
    }
}
