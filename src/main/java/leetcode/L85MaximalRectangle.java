package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L85MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] histogram = buildHistogram(matrix);
        for (int[] h : histogram) {
            max = Math.max(max, getHistogramMaxArea(h));
        }
        return max;
    }

    public int getHistogramMaxArea(int[] m) {
        int max = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < m.length; i++) {
            while(!stack.isEmpty() && m[stack.peek()] > m[i]) {
                int cur = stack.pop();
                int curH = m[cur];
                int left = stack.peek();
                max = Math.max(max, curH * (i - left - 1));
            }
            stack.push(i);
        }
        return max;
    }

    public int[][] buildHistogram(char[][] matrix) {
        int[][] hist = new int[matrix.length][matrix[0].length + 2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0')
                    hist[i][j + 1] = 0;
                else {
                    if (i == 0) {
                        hist[i][j + 1] = 1;
                    } else {
                        hist[i][j + 1] = hist[i - 1][j + 1] + 1;
                    }
                }
            }
        }
        return hist;
    }

    public static void main(String[] args) {
        L85MaximalRectangle l = new L85MaximalRectangle();
        char[][] arr = new char[][] {
                new char[] {'1', '0', '1', '0', '0'},
                new char[] {'1', '0', '1', '1', '1'},
                new char[] {'1', '1', '1', '1', '1'},
                new char[] {'1', '0', '0', '1', '0'}
        };
//        int[][] a = l.buildHistogram(arr);
//        for (int[] aa : a) {
//            for (int aaa : aa) System.out.print(aaa + " ");
//            System.out.println("");
//        }
        System.out.println(l.maximalRectangle(arr));
    }
}
