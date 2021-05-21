package leetcode;

import jdk.nashorn.internal.parser.JSONParser;

public class StringtoIntegerAtoi {

    public static int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        int sign = 1;
        long res = 0;
        for(int i =0;i<s.length();i++){
            if(i==0){
                if(s.charAt(i)=='-') {
                    sign = -1;
                    continue;
                }else if(s.charAt(i)=='+'){
                    sign = 1;
                    continue;
                }
            }
            int tmp = s.charAt(i)-'0';
            if(tmp>=0 && tmp<=9) {
                res = res * 10 + tmp;
                if(sign>0 && res>Integer.MAX_VALUE)return Integer.MAX_VALUE;
                if(sign<0 && res<Integer.MIN_VALUE)return Integer.MIN_VALUE;
//                System.out.println(res);
            }else{
                break;
            }
        }
        res = res*sign;

        if(res>= Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(res<= Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return (int)res;
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("  -0012a42"));
//        System.out.println(myAtoi("asd -0012a42"));
//        System.out.println(myAtoi("   -42"));
//        System.out.println(myAtoi("4193 with words"));
//        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("18446744073709551617"));
    }
}
