package leetcode;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
//        if(strs.length==1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = minLen > strs[i].length()?strs[i].length():minLen;
        }
        String s = "";
        for (int i = 0; i < minLen; i++) {
            String tmp="";
            for(int j=0;j< strs.length;j++) {
                if(tmp.isEmpty()){
                    tmp = String.valueOf(strs[j].charAt(i));
                }else{
                    if(!tmp.equals(String.valueOf(strs[j].charAt(i)))){
                        return s;
                    }
                }
            }
            s+=strs[0].charAt(i);
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","floight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
