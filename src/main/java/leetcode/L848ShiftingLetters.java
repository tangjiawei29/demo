package leetcode;

public class L848ShiftingLetters {
    //    public String shiftingLetters(String s, int[] shifts) {
//        for (int i = shifts.length - 2; i >= 0; i--) {
//            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
//        }
//
//        char[] ans = s.toCharArray();
//        for (int i = 0; i < shifts.length; i++) {
//            ans[i] = (char) ((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a');
//
//        }
//        return new String(ans);
//    }
    public String shiftingLetters(String s, int[] shifts) {
        char[] ans = s.toCharArray();
        int n = s.length();
        ans[n-1] = (char) ((ans[n-1] - 'a' + shifts[n-1]) % 26 + 'a');
        for (int i = n - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
            ans[i] = (char) ((ans[i] - 'a' + shifts[i]) % 26 + 'a');
        }

        return new String(ans);
    }

    public static void main(String[] args) {
        L848ShiftingLetters l = new L848ShiftingLetters();
        System.out.println(l.shiftingLetters("mkg", new int[] {505870226, 437526072, 266740649}));
    }
}
