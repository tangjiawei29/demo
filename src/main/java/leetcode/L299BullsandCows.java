package leetcode;

public class L299BullsandCows {

    public static String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] se = new int[10];
        int[] gu = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                se[secret.charAt(i) - '0']++;
                gu[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            B += Math.min(se[i], gu[i]);
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
