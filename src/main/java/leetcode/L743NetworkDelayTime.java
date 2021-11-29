package leetcode;

import java.util.Arrays;

public class L743NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                map[i][j] = 9999;
            }
        }
        int[] distance = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        isVisited[k] = true;

        for(int i=1;i<distance.length;i++){
            distance[i]=9999;
        }
        for (int i = 0; i < times.length; i++) {
            int src = times[i][0];
            int des = times[i][1];
            int time = times[i][2];
            map[src][des] = time;
        }

        myDijkstra(k, map, distance, isVisited);
        int res = -1;
        for (int i = 1; i < distance.length; i++) {
            res = distance[i] > res ? distance[i] : res;
        }
        return res == 9999 ? -1 : res;
    }

    private static void myDijkstra(int startNode, int[][] map, int[] distance, boolean[] isVisited) {
        int n = distance.length - 1;
        for (int i = 1; i <= n; i++) {
            distance[i] = map[startNode][i];
        }
        distance[startNode] = 0;
        for (int i = 1; i < n; i++) {
            int tmpMin = 9999;
            int idx = 0;
            for (int j = 1; j <= n; j++) {
                if (!isVisited[j] && distance[j] < tmpMin) {
                    tmpMin = distance[j];
                    idx = j;
                }
            }
            isVisited[idx] = true;

            for (int j = 1; j <= n; j++) {
                if (!isVisited[j] && map[idx][j] < 9999) {
                    if (tmpMin + map[idx][j] < distance[j]) {
                        distance[j] = tmpMin + map[idx][j];
                    }
                }
            }
//            System.out.println(i+" "+idx+" "+tmpMin);
//            for (int ij = 1; ij < distance.length; ij++) {
//                System.out.print(distance[ij] + " ");
//            }
//            System.out.println("");
//            for (int ij = 1; ij < distance.length; ij++) {
//                System.out.print(isVisited[ij] + " ");
//            }
//            System.out.println("\n-----");
        }
    }


    public static void main(String[] args) {
        L743NetworkDelayTime l = new L743NetworkDelayTime();
//        int[][] a = new int
        System.out.println(l.networkDelayTime(new int[][] {
                        new int[] {2, 1, 1}, new int[] {2, 3, 1}, new int[] {3, 4, 1}},
                4, 2));

//        System.out.println(l.networkDelayTime(new int[][] {
//                        new int[] {1, 2, 1}, new int[] {2, 3, 2}, new int[] {1, 3, 1}},
//                3, 2));
    }
}
