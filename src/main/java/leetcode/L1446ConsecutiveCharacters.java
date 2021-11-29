package leetcode;

public class L1446ConsecutiveCharacters {
    public int maxPower(String s) {
        int max = 1;
        char[] arr = s.toCharArray();
        int cnt = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }
        return Math.max(max, cnt);
    }
}
