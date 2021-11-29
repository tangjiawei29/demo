package graph;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    static class edge {
        public int src;   //边的起点
        public int tar;   //边的终点
        public int value;  //边的权值

        edge(int a, int b, int value) {
            this.src = a;
            this.tar = b;
            this.value = value;
        }
    }

    static int max = 9999;

    public static void main(String[] args) {
        int n = 5;
        List<edge> edges = new ArrayList<edge>();
        edges.add(new edge(1, 2, -1));
        edges.add(new edge(1, 3, 4));
        edges.add(new edge(2, 3, 3));
        edges.add(new edge(2, 4, 2));
        edges.add(new edge(4, 2, 1));
        edges.add(new edge(4, 3, 5));
        edges.add(new edge(2, 5, 2));
        edges.add(new edge(5, 4, -3));


        int dist[] = new int[n + 1];

        for (int i = 1; i < dist.length; i++) {
            dist[i] = max;
        }
        dist[1] = 0;

        System.out.println(myBellmanFord(edges, n, dist));

        for (int i = 1; i < dist.length; i++) {
            System.out.println(dist[i]);
        }
    }

    private static boolean myBellmanFord(List<edge> edges, int n, int[] dist) {
        for (int i = 1; i < n; i++) {
            for (edge e : edges) {
                int s = e.src;
                int t = e.tar;
                int v = e.value;
                dist[t] = Math.min(dist[t], dist[s] + v);
            }
        }
        for (int i = 0; i < edges.size(); i++) {
            if (dist[edges.get(i).tar] > dist[edges.get(i).src] + edges.get(i).value) {
                return false;
            }
        }
        return true;
    }

}
