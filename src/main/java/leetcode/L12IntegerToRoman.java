package leetcode;

public class L12IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer buf = new StringBuffer();
        int idx = 0;
        while(num>0){
            while(values[idx] <= num) {
                num -= values[idx];
                buf.append(strs[idx]);
            }
            idx++;
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        L12IntegerToRoman l = new L12IntegerToRoman();
        System.out.println(l.intToRoman(58));//lviii
        System.out.println(l.intToRoman(1994));//mcmxciv
    }
}
