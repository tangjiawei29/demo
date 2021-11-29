package leetcode;

public class L507PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1;

        int len = (int) Math.sqrt(num);
        for (int i = 2; i <= len; i++) {
            if (num % i == 0) {
                int d = num / i;
                if (i == d) d = 0;
                sum = sum + i + d;
            }
        }
        //System.out.println(sum);

        return sum == num;
    }
}
