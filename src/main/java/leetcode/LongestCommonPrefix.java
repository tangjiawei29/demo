package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        int len = strs.length;
        if (len == 0)
            return "";
        int minlen = 0x7fffffff;
        for (int i = 0; i < len; ++i)
            minlen = Math.min(minlen, strs[i].length());
        for (int j = 0; j < minlen; ++j)
            for (int i = 1; i < len; ++i) {
                System.out.println(strs[0].charAt(j));
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        return strs[0].substring(0, minlen);
    }
    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>();
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(10);
        System.out.println(priorityQueue.peek());
//        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
//        System.out.println(longestCommonPrefix(new String[]{"flower","flow","floight"}));
//        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
