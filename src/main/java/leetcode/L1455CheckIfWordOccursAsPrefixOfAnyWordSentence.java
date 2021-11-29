package leetcode;

import java.util.HashSet;

public class L1455CheckIfWordOccursAsPrefixOfAnyWordSentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].startsWith(searchWord))
                return i + 1;
        }
        return -1;
    }

    public int isPrefixOfWord2(String sentence, String searchWord) {
        sentence = " " + sentence;
        int idx = sentence.indexOf(" " + searchWord);
        if (idx == -1)
            return -1;
        int cntZero=0;
        for(int i=0;i<idx;i++){
            if(sentence.charAt(i)==' ')
                cntZero++;
        }
        return cntZero+1;
    }


    public static void main(String[] args) {
        L1455CheckIfWordOccursAsPrefixOfAnyWordSentence a = new L1455CheckIfWordOccursAsPrefixOfAnyWordSentence();
        System.out.println(a.isPrefixOfWord2("hello from the other side",
                "th"));
    }
}
