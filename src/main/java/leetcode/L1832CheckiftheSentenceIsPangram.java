package leetcode;

public class L1832CheckiftheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
//         boolean[] arr = new boolean[26];
//         for(char c : sentence.toCharArray()){
//              arr[c-'a'] = true;

//         }
//         for(boolean b : arr){
//             if(!b) return false;
//         }
//         return true;

        for (int i = 0; i <= 25; i++) {
            if (sentence.indexOf((char) ('a' + i)) < 0)
                return false;
        }
        return true;
    }
}
