package leetcode;

public class L1306JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return jump(arr, visited, start);
    }

    public boolean jump(int[] arr, boolean[] visited, int start) {
        if (start < 0 || start >= arr.length) return false;
        if (arr[start] == 0) return true;
        if (visited[start]) return false;
        visited[start] = true;
        return jump(arr, visited, start + arr[start]) || jump(arr, visited, start - arr[start]);

    }

    public static void main(String[] args) {
        L1306JumpGameIII g = new L1306JumpGameIII();
        System.out.println(g.canReach(new int[] {3, 0, 2, 1, 2}, 2));
    }
}
