package leetcode;

public class L1189MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[5];
        for (char c : text.toCharArray()) {
            switch (c) {
                case 'b':
                    arr[1] += 1;
                    break;
                case 'a':
                    arr[0] += 1;
                    break;
                case 'l':
                    arr[2] += 1;
                    break;
                case 'o':
                    arr[4] += 1;
                    break;
                case 'n':
                    arr[3] += 1;
                    break;
            }
        }
        arr[2] /= 2;
        arr[4] /= 2;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(i, min);
        }
        return min;
    }
}
