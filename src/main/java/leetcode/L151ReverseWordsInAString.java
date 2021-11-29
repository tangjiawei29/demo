package leetcode;

public class L151ReverseWordsInAString {
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] ss = s.split(" ");
        for(int i = ss.length-1;i>=0;i--){
            String sss = ss[i];
            if(sss.length()>0)
                sb.append(sss).append(" ");
        }
        return sb.toString().trim();
    }
}
