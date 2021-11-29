package leetcode;

public class L27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                r--;
            } else {
                l++;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        L27RemoveElement l = new L27RemoveElement();
        System.out.println(l.removeElement(new int[] {2, 3, 4, 1, 2, 3, 1, 2}, 2));
    }
}
