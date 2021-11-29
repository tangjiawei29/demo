package leetcode;

public class L34FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int rL = -1, rR = -1;
        while(l <= r) {

            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                rL = mid;
                rR = mid;
                while(rL >= 1) {

                    if (nums[rL-1] != target)
                        break;
                    rL--;
                }
                while(rR < n-1) {

                    if (nums[rR+1] != target)
                        break;
                    rR++;
                }
                return new int[] {rL, rR};
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return new int[] {rL, rR};
    }

    public static void main(String[] args) {
        L34FindFirstandLastPositionofElementinSortedArray a = new L34FindFirstandLastPositionofElementinSortedArray();
        System.out.println(a.searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
    }
}
