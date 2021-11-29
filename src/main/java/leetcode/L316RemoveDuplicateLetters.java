package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class L316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int c = cur - 'a';
            if (visited[c]) continue;
            while(deque.size() > 0 && deque.peekLast() > cur && lastIndex[deque.peekLast()-'a'] > i) {
                visited[deque.peekLast()-'a'] = false;
                deque.pollLast();
            }
            visited[c] = true;
            deque.addLast(cur);
        }
//        StringBuffer sb = new StringBuffer();
//        deque.forEach(sb::append);
//        deque.stream().map(Object::toString).collect(Collectors.joining());
//        while(deque.size() > 0) {
//            sb.append(deque.pollFirst());
//        }
        return deque.stream().map(Object::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println("a".substring(0,1));
//        L316RemoveDuplicateLetters l = new L316RemoveDuplicateLetters();
//        System.out.println(l.removeDuplicateLetters("cbacdcbc"));
    }
}
