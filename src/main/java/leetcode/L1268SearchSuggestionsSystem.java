package leetcode;

import dataStructure.ListNode;
import dataStructure.Node;
import dataStructure.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

public class L1268SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = buildTrie(products);

        List<List<String>> res = new ArrayList();
        for (int i = 1; i <= searchWord.length(); i++) {
            res.add(search(root, searchWord.substring(0, i)));
        }
        return res;
    }

    private List<String> search(TrieNode root, String search) {
        List<String> list = new ArrayList();
        TrieNode cur = root;
        for (int i = 0; i < search.length(); i++) {
            cur = cur.children[search.charAt(i) - 'a'];
            if (cur == null) {
                return list;
            }
        }
        dfs(list, cur, search);

        return list;
    }

    private void dfs(List<String> list, TrieNode root, String search) {
        if (list.size() == 3) return;

        if (root.isWord) list.add(search);
        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null)
            dfs(list, root.children[i], search + (char) ('a' + i));
        }

    }

    public TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode();
        for (String s : products) {
            if (s == null) continue;
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];

            }
            cur.isWord = true;
        }
        return root;
    }

    public static void main(String[] args) {
        L1268SearchSuggestionsSystem a = new L1268SearchSuggestionsSystem();
        a.suggestedProducts(new String[] {"bags","baggage","banner","box","cloths"}, "bags")
                .forEach(t -> System.out.println(t));
    }
}
