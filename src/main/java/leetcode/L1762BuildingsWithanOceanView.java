package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1762BuildingsWithanOceanView {
    public int[] findBuildings(int[] heights) {
        List<Integer> st = new ArrayList();
        int max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (st.isEmpty() || heights[i] > max) {
                st.add(i);
                max = Math.max(heights[i], max);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = st.get(ans.length - 1 - i);
        return ans;
    }
}
