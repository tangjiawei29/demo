package dataStructure;

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}
public class Trie {
    private TrieNode root = null;
    /** Initialize your data structure here. */
    public Trie() {
       root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null)return;
        TrieNode tn = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(tn.children[idx]==null) {
                tn.children[idx] = new TrieNode();
            }
            tn = tn.children[idx];
        }
        tn.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tn = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (tn.children[idx] == null) {
                return false;
            }
            tn = tn.children[idx];
        }
        return tn.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tn = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (tn.children[idx] == null) {
                return false;
            }
            tn = tn.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("app");
        System.out.println(t.startsWith("appp"));
    }
}