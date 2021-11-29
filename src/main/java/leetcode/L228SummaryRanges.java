package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i + 1 == n || nums[i] + 1 != nums[i + 1]) {
                StringBuffer sb = new StringBuffer();
                sb.append(nums[start]);
                if (i != start) {
                    sb.append("->").append(nums[i]);
                }
                ans.add(sb.toString());
                start = i + 1;
            }
        }
        return ans;
    }

    public List<String> summaryRangesBrute(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();

        List<List<Integer>> lst = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int prev = nums[0];
        l.add(prev);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev != 1) {
                lst.add(l);
                l = new ArrayList<>();
            }
            l.add(nums[i]);
            prev = nums[i];
        }
        lst.add(l);
        for (List<Integer> ll : lst) {
            if (ll.size() == 1) {
                ans.add(ll.get(0) + "");
            } else {
                ans.add(String.format("%d->%d", ll.get(0), ll.get(ll.size() - 1)));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L228SummaryRanges l = new L228SummaryRanges();
        System.out.println(l.summaryRanges(new int[] {0, 2, 3, 4, 6, 7, 9, 10}));
    }
}
