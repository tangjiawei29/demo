package leetcode;

public class L371SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int tmp = 0;
        while(b != 0) {
            tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }
}
