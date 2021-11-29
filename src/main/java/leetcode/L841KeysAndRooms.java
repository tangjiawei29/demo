package leetcode;

import java.util.List;

public class L841KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;

    }

    private void dfs(List<List<Integer>> rooms, int i, boolean[] visited) {
        if (visited[i]) return;

        visited[i] = true;
        for (int idx : rooms.get(i)) {
            if (i == idx) continue;
            dfs(rooms, idx, visited);
        }
    }
}
