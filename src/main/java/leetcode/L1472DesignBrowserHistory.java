package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L1472DesignBrowserHistory {
    List<String> lst = null;
    int idx = -1;

    public L1472DesignBrowserHistory(String homepage) {
        lst = new ArrayList();
        lst.add(homepage);
        idx = 0;
    }

    public void visit(String url) {
        for (int i = idx + 1; lst.size() - i > 0; ) {
            lst.remove(lst.size() - 1);
        }
        lst.add(url);
        idx = lst.size() - 1;
    }

    public String back(int steps) {
        if (idx - steps < 0) {
            idx = 0;
        } else {
            idx -= steps;
        }
        return lst.get(idx);
    }

    public String forward(int steps) {
        if (idx + steps >= lst.size()) {
            idx = lst.size() - 1;

        } else {
            idx += steps;
        }
        return lst.get(idx);
    }
}
