package leetcode;

public class L537ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        int a = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
        int c = Integer.parseInt(num2.substring(0, num2.indexOf('+')));
        int b = Integer.parseInt(num1.substring(num1.indexOf('+') + 1, num1.length() - 1));
        int d = Integer.parseInt(num2.substring(num2.indexOf('+') + 1, num2.length() - 1));
        return new StringBuffer().append((a * c - b * d)).append('+').append(a * d + b * c).append('i').toString();
    }
}
