package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L539MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n>=1440) return 0;
        int[] time = new int[n];
        for (int j = 0; j < n; j++) {
            time[j] = getTime(timePoints.get(j));
        }

        Arrays.sort(time);
        int min = getTimeDiff(time[0], time[n - 1]);
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, time[i + 1] - time[i]);
        }
        return min;
    }

    public int getTimeDiff(int t1, int t2) {
        if (t1 > t2) return getTimeDiff(t2, t1);
        return t2 - t1 > 720 ? 1440 - t2 + t1 : t2 - t1;
    }

    public int getTime(String time) {
        return Integer.valueOf(time.substring(0, 2)) * 60 + Integer.valueOf(time.substring(3));
    }

    public static void main(String[] args) {
        L539MinimumTimeDifference a = new L539MinimumTimeDifference();
        List<String> timePoints = new ArrayList<>();
        timePoints.add("00:00");
        timePoints.add("23:59");
        timePoints.add("00:02");
        System.out.println(a.findMinDifference(timePoints));
    }
}
