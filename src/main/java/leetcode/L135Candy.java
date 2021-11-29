package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class L135Candy {
    public int candy(int[] r) {
        int[] res = new int[r.length];
        Arrays.fill(res, 1);
        for (int i = 1; i < r.length; i++) {
            if (r[i] > r[i - 1]) {
                res[i] += res[i - 1];
            }
        }

        for (int i = r.length - 2; i >= 0; i--) {
            if (r[i] > r[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i : res) {
            ans += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        L135Candy o = new L135Candy();
        System.out.println(o.candy(new int[] {1, 3, 2, 2, 1}));

    }
}
