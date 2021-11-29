package leetcode;

public class L1535FindtheWinnerofanArrayGame {
    public int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int round = 0;
        for (int i = 1; i < arr.length; i++) {
            if (winner >= arr[i]) {
                round++;
            } else {
                winner = arr[i];
                round = 1;
            }
            if (round == k) break;
        }
        return winner;
    }
}
