package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L447NumberOfBoomerangs {
    int cnt = 0;


    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int dis = getDis(points[i], points[j]);
                    map.put(dis, map.getOrDefault(dis, 0) + 1);
                }
            }
            for (int c : map.values()) {
                cnt += c * (c - 1);
            }
        }
        return cnt;
    }


    public int numberOfBoomerangsBackTracking(int[][] points) {//TLE
        backtracking(new ArrayList(), points, 0, points.length);
        return cnt;
    }

    private void backtracking(List<Integer> lst, int[][] points, int idx, int n) {
        if (lst.size() == 3) {
            if (getDis(points[lst.get(0)], points[lst.get(1)])
                    == getDis(points[lst.get(0)], points[lst.get(2)])) {
//                System.out.print("√");
                cnt++;
            }
//            System.out.println("======");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (lst.contains(i)) continue;
            lst.add(i);
            backtracking(lst, points, i + 1, n);
            lst.remove(lst.size() - 1);
        }
    }

    private int getDis(int[] a, int[] b) {
        return (a[1] - b[1]) * (a[1] - b[1]) + (a[0] - b[0]) * (a[0] - b[0]);
    }

    public static void main(String[] args) {
        L447NumberOfBoomerangs l = new L447NumberOfBoomerangs();
        System.out.println(l.numberOfBoomerangs(new int[][] {{0, 0}, {1, 0}, {2, 0}}));
    }
}

