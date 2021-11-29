package leetcode;

import java.util.PriorityQueue;

public class L1845SeatReservationManager {
    PriorityQueue<Integer> pq;
    int min = 1;
    public L1845SeatReservationManager(int n) {
        pq = new PriorityQueue<>();
    }

    public int reserve() {
        if(pq.isEmpty()) return min++;
        else return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }

}
