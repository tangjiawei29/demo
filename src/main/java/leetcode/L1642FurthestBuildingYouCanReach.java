package leetcode;

import java.util.PriorityQueue;

public class L1642FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i] - heights[i + 1];
            if (diff >= 0)
                continue;
            pq.offer(-diff);
            if (pq.size() <= ladders) continue;
            int minBricks = pq.poll();
            bricks -= minBricks;
            if (bricks < 0)
                return i;
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        L1642FurthestBuildingYouCanReach l = new L1642FurthestBuildingYouCanReach();
        System.out.println(l.furthestBuilding(new int[] {4,12,2,7,3,18,20,3,19}, 10, 2));
    }
}
