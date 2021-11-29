package leetcode;

import java.util.Stack;

public class L739DailyTemperatures {
    public int[] dailyTemperatures(int[] t) {
        int[] arr = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i <= t.length - 1; i++) {
            while(!stack.isEmpty() && t[stack.peek()] < t[i]) {
                int idx = stack.peek();
                arr[idx] = i - stack.pop();
            }
            stack.push(i);

        }
//        SortUtil.printArray(arr);
        return arr;
    }

    public int[] dailyTemperaturesBrute(int[] t) {
        int[] arr = new int[t.length];
        for (int i = 0; i < t.length - 1; i++) {
            int diff = 0;
            for (int j = i + 1; j < t.length; j++) {
                if (t[i] < t[j]) {
                    diff = j - i;
                    break;
                }
            }
            arr[i] = diff;
        }
        return arr;
    }

    public static void main(String[] args) {
        L739DailyTemperatures l = new L739DailyTemperatures();
        System.out.println(l.dailyTemperatures(new int[] {30, 60, 90}));

        System.out.println(l.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
