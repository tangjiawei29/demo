package leetcode;

import jdk.nashorn.internal.parser.JSONParser;

public class RomanToInteger {

    public static int romanToInt(String s) {
        int res = 0;
        if(s==null||s.length()==0)return 0;
        if(s.length()==1) return getVal(s.charAt(0));
        res = getVal(s.charAt(s.length()-1));
        for (int i = s.length()-1; i > 0 ; i--) {
            int val = getVal(s.charAt(i));
            int val2 = getVal(s.charAt(i-1));
            res += val <= val2 ? val2 : -val2;
        }
        return  res;
    }

    public static int getVal(char c) {
        switch(c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D' :
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(String.format("%s %d","LVIII 58",romanToInt("LVIII")));
        System.out.println(System.currentTimeMillis()-t1);
        t1 = System.currentTimeMillis();
        System.out.println(String.format("%s %d","MCMXCIV 1994",romanToInt("MCMXCIV")));
        System.out.println(System.currentTimeMillis()-t1);
    }
}
