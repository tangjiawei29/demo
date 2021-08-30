package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L299BullandCows {

    public static String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        List<Integer>[] arr = new ArrayList[10];
        char[] secretArr = secret.toCharArray();
        char[] guessArr = guess.toCharArray();
        for (int i = 0; i < 10; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < secretArr.length; i++) {
            arr[secretArr[i] - '0'].add(i);
        }

        for (int i = 0; i < guessArr.length; i++) {
            if (arr[guessArr[i] - '0'].size() > 0) {
                if (arr[guessArr[i] - '0'].indexOf((Object) i) >= 0) {
                    arr[guessArr[i] - '0'].remove((Object) i);
                    guessArr[i] = '*';
                    A++;
                }
            }
        }
        for (int i = 0; i < guessArr.length; i++) {
            if (guessArr[i] == '*') continue;
            if (arr[guessArr[i] - '0'].size() > 0) {
                if (arr[guessArr[i] - '0'].indexOf((Object) i) == -1) {
                    arr[guessArr[i] - '0'].remove(arr[guessArr[i] - '0'].size() - 1);
                    B++;
                }
            }
        }

        return new StringBuffer().append(A).append('A').append(B).append('B').toString();
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("11", "10"));
        System.out.println(getHint("0", "1"));
    }
}
