package leetcode;

public class L1629SlowestKey {
    public char slowestKey(int[] times, String key) {
        char[] keys = key.toCharArray();
        char ans = keys[0];
        int maxDur = times[0];
        for (int i = 1; i < keys.length; i++) {
            if (times[i] - times[i - 1] > maxDur) {
                maxDur = times[i] - times[i - 1];
                ans = keys[i];
            } else if (times[i] - times[i - 1] == maxDur) {
                ans = ans > keys[i] ? ans : keys[i];
            }
        }
        return ans;
    }
}
