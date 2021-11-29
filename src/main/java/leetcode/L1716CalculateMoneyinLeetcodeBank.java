package leetcode;

public class L1716CalculateMoneyinLeetcodeBank {
    public int totalMoney(int days) {
        int m = days / 7;
        int n = days % 7;
        return (49 + 7 * m) * m / 2 + ((1 + n) * n / 2) + m * n;
    }
}
