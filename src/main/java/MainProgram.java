import java.util.HashSet;

public class MainProgram {
    public MainProgram() {

    }
    public int lengthOfLongestSubstring(String s) {

        if(s==null||s.length()==0)return 0;
        if(s.length()==1)return 1;
        int max = 0;
        HashSet h = new HashSet();
        for(int i =0;i<s.length();i++){
            h.clear();
            for(int j =i;j<s.length();j++){
               if(h.contains(s.charAt(j)) ) {
                   max = max < h.size() ? h.size() : max;
                   System.out.println("max"+max);
                   break;
               }
               h.add(s.charAt(j));
                max = max < h.size() ? h.size() : max;
               System.out.println(h.toString());
            }
        }
        return max;
    }
    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        HashSet<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public boolean isPalindromic(String s){
        if(s.isEmpty()) return true;

        int mid = s.length()/2;
        int endIdx = s.length()-1;
        for (int i = 0; i < mid; i++) {
            if(s.charAt(i)!=s.charAt(endIdx-i)){
                return false;
            }
        }
        return true;



    }

    public static void main(String[] args) {
        MainProgram mp = new MainProgram();
//        System.out.println(mp.lengthOfLongestSubstring("abcabcabc")+" 3");
//        System.out.println(mp.lengthOfLongestSubstring("bbbbb")+" 1");
//        System.out.println(mp.lengthOfLongestSubstring("au")+" 2");
        System.out.println("aaa".substring(0,2));
    }
}
