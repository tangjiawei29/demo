package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1078OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        if(text.length()==1)return new String[]{};
        List<String> lst = new ArrayList();
        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length-2; i++) {
            if(arr[i].equals(first)&&arr[i+1].equals(second)){
                lst.add(arr[i+2]);
            }
        }

        return lst.toArray(new String[]{});
    }

    public static void main(String[] args) {
        L1078OccurrencesAfterBigram o = new L1078OccurrencesAfterBigram();
        o.findOcurrences("alice is a good girl she is a good student","a","good");
        o.findOcurrences("we will we will rock you","we","rock");
    }
}
