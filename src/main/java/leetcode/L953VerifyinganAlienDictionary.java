package leetcode;

public class L953VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i <= 25; i++) {
            orders[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(orders, words[i], words[i + 1]))
                return false;
        }
        return true;
    }

    private boolean compare(int[] orders, String w1, String w2) {
        int idx1 = 0;
        while(idx1 < w1.length() && idx1 < w2.length()) {
            if (orders[w1.charAt(idx1) - 'a'] < orders[w2.charAt(idx1) - 'a'])
                return true;
            else if (orders[w1.charAt(idx1) - 'a'] > orders[w2.charAt(idx1) - 'a'])
                return false;
            idx1++;
        }
        return w1.length() <= w2.length();
    }
}
