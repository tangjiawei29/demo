package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L886PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] arr : dislikes) {
            graph[arr[0] - 1].add(arr[1] - 1);
            graph[arr[1] - 1].add(arr[0] - 1);
        }

        int[] colorArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (colorArr[i] == 0 && !dfs(graph, colorArr, i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] graph, int[] colorArr, int idx, int color) {
        colorArr[idx] = color;
        for (int g : graph[idx]) {
            if (colorArr[g] == color) {
                return false;
            }
            if (colorArr[g] == 0 && !dfs(graph, colorArr, g, -color)) {
                return false;
            }
        }
        return true;
    }
}
