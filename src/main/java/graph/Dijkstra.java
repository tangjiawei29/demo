package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    static int max = 9999;

    public static void main(String[] args) {
        int n = 7;
        int map[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                map[i][j] = max;
        map[1][2] = 1;
        map[1][3] = 12;
//        map[1][7] = 5;
        map[2][4] = 3;
        map[2][3] = 9;
        map[3][5] = 5;
        map[4][3] = 4;
        map[4][5] = 13;
        map[4][6] = 15;
        map[5][6] = 4;
//        map[7][6]=1;
        int v = 1;
        int dist[] = new int[n + 1];
        int prev[] = new int[n + 1]; //记录的是源到顶点i上最短路径上的前一个顶点
        boolean[] isVisited = new boolean[n + 1];

        for (int i = 1; i < dist.length; i++) {
            dist[i] = max;
            isVisited[i] = false;
        }

        dist[v] = 0;
        prev[v] = 0;
        long t1 = System.currentTimeMillis();

        myDijkstraUsingPriorityQueue(v, map, dist, prev, isVisited);
//        Dijkstra1(v,map,dist,prev);
        List<Integer> l = new ArrayList<Integer>();
        int idx = 6;
        while(prev[idx] != 0) {
            l.add(prev[idx]);
            idx = prev[idx];
        }
        Collections.reverse(l);
        l.forEach(t -> System.out.println(t));
    }


    private static void myDijkstra(int startNode, int[][] map, int[] distance, int[] prevNode, boolean[] isVisited) {
        int n = distance.length - 1;
        isVisited[startNode] = true;
        for (int i = 1; i <= n; i++) {
            distance[i] = map[startNode][i];
            if (distance[i] < max) {
                prevNode[i] = startNode;
            }
        }
        for (int i = 1; i < n; i++) {
            int tmpMin = max;
            int idx = 0;
            for (int j = 1; j <= n; j++) {
                if (!isVisited[j] && distance[j] < tmpMin) {
                    tmpMin = distance[j];
                    idx = j;
                }
            }
            isVisited[idx] = true;

            for (int j = 1; j <= n; j++) {
                if (!isVisited[j] && map[idx][j] < max) {
                    if (tmpMin + map[idx][j] < distance[j]) {
                        distance[j] = tmpMin + map[idx][j];
                        prevNode[j] = idx;
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

    static class Node {
        int node;
        int dis;

        Node(int n, int d) {
            node = n;
            dis = d;
        }
    }

    private static void myDijkstraUsingPriorityQueue(int startNode, int[][] map, int[] distance, int[] prevNode, boolean[] isVisited) {
        int n = distance.length - 1;

        PriorityQueue<Node> pq = new PriorityQueue<Node>((x,y)->x.dis-y.dis);
        pq.offer(new Node(startNode,distance[startNode]));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if (isVisited[node.node]) continue;
            isVisited[node.node]=true;
            for (int i = 1; i < map[node.node].length; i++) {
                if(isVisited[i]==true) continue;
                if(distance[i]>distance[node.node]+map[node.node][i]){
                    distance[i] = distance[node.node]+map[node.node][i];
                    pq.offer(new Node(i,distance[i]));
//                    System.out.println("add Node: "+i+" "+distance[i]);
                    prevNode[i] = node.node;
                }
            }
//            System.out.println(pq.size());
        }

    }


    //源点，邻接矩阵，存储答案的数组，路径存储
    private static void Dijkstra1(int v, int[][] map, int[] dist, int[] prev) {
        int n = dist.length - 1;
        boolean visit[] = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = map[v][i];//源点到各个节点的距离
            visit[i] = false;
            if (map[v][i] < max) prev[i] = 0;  //不存在(都没有路径嘛)
            else prev[i] = v;

        }
        visit[v] = true;
        dist[v] = 0;
        //每一次循环都可以创造一个最短路径
        for (int i = 1; i <= n; i++) {
            int temp = max;    //从源到index中的最小和的值
            int index = 0;    //dist中最小的那个节点
            //这里找出dist中的最小值,并记录是哪个节点
            for (int j = 1; j <= n; j++) {
                if (!visit[j] && temp > dist[j]) {
                    temp = dist[j];
                    index = j;
                }
            }
            System.out.println(index);
            visit[index] = true;
            //从最短路径那里再往外衍生更新dist中的最短路径
            for (int j = 1; j <= n; j++) {
                if (!visit[j] && map[index][j] < max) {
                    int newdist = temp + map[index][j];
                    if (newdist < dist[j]) {
                        dist[j] = newdist;
                        prev[j] = index;  //与dist数组一样，这个是动态修改的，只会在最后一步确定结果

                    }
                }
            }
            for (int ij = 1; ij < dist.length; ij++) {
                System.out.print(dist[ij] + " ");
            }
            System.out.println("");
        }

    }
}
