package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1233RemoveSubFoldersfromtheFilesystem {
    class Trie {
        Trie[] child = new Trie[27];
        boolean isEnd = false;
        boolean add(String s) {
            Trie root = this;
            for (char c : s.toCharArray()) {
                if (c == '/' && root.isEnd) {
                    return false;
                }
                int i = c - 'a';
                if (c == '/') {
                    i = 26;
                }
                if (root.child[i] == null) {
                    root.child[i] = new Trie();
                }
                root = root.child[i];
            }
            root.isEnd = true;
            return true;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        List<String> l = new ArrayList();
        Arrays.sort(folder, (x, y) -> x.length() - y.length());
        Trie root = new Trie();
        for (String s : folder) {
            if (root.add(s))
                l.add(s);
        }
        return l;
    }

    public static void main(String[] args) {
        L1233RemoveSubFoldersfromtheFilesystem l = new L1233RemoveSubFoldersfromtheFilesystem();
//        System.out.println(l.removeSubfolders(new String[] {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}).toString());
        System.out.println(l.removeSubfolders(new String[] {"/a", "/a/b/c", "/a/b/d"}).toString());

    }
}
