package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17LetterCombinationsofPhoneNumber {

    String[] arr = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<String>();
        getStr("",digits, list, 0);
        return list;
    }
    public void getStr(String prefix,String digits, List<String> list, int offset){
        if(offset==digits.length()){
            list.add(prefix);
            return;
        }
        String res = arr[digits.charAt(offset)-'0'];
        for(int i=0;i<res.length();i++) {
            //prefix=prefix+res.charAt(i);
            getStr(prefix+res.charAt(i),digits,list,offset+1);
        }
    }

    public static void main(String[] args) {
        L17LetterCombinationsofPhoneNumber p = new L17LetterCombinationsofPhoneNumber();
        System.out.println(p.letterCombinations("23").toString());
        System.out.println(p.letterCombinations("").toString());
        System.out.println(p.letterCombinations("2").toString());
    }
}
