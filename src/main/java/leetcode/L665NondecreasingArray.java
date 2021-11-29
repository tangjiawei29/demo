package leetcode;

public class L665NondecreasingArray {
    public boolean checkPossibility(int[] nums) {
        //2 4 2 6
        //3 4 2 6
        if (nums.length <= 2) return true;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (flag) return false;
                flag = true;
                if (i >= 2 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(6>>1);
    }
}
