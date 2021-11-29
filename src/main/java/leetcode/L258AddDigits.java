package leetcode;

public class L258AddDigits {
    public int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }

    public static void main(String[] args) {
        L258AddDigits l = new L258AddDigits();
        System.out.println(l.addDigits(66));
    }
}
