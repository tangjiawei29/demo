package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L84LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] arr = new int[heights.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = 0;
        for (int i = 1; i < heights.length + 1; i++) {
            arr[i] = heights[i - 1];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                int cur = stack.pollLast();
                int curH = arr[cur];
                int left = stack.peekLast();
                int right = i;
//                System.out.println(stack.toString());
//                System.out.println(String.format("%d %d %d %d", cur, left, right,(right - left - 1) * curH));
                res = Math.max(res, (right - left - 1) * curH);
            }
            stack.add(i);
        }
        return res;
    }

    public int largestRectangleAreaBrute(int[] heights) {
        int res = 0;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            for (int j = i; j >= 0; j--) {
                if (heights[i] > heights[j]) {
                    break;
                }
                l = j;
            }

            for (int j = i; j < n; j++) {
                if (heights[i] > heights[j]) {
                    break;
                }
                r = j;
            }
            res = Math.max(res, heights[i] * (r - l + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        L84LargestRectangleinHistogram l = new L84LargestRectangleinHistogram();
        System.out.println(l.largestRectangleArea(new int[] {1, 2, 3, 2, 4, 5}));
    }
}
