package leetcode;

import java.util.ArrayList;
import java.util.List;

public class L282ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> lst = new ArrayList();
        backtracking(lst, num, "", 0, target, 0, 0);
        return lst;
    }

    private void backtracking(List<String> lst, String num, String path, int index, int target, long cur, long prev) {
        if (index == num.length()) {
            if (cur == target) {
                lst.add(path);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long curNum = Long.valueOf(num.substring(index, i+1));
            if (index == 0) {
                backtracking(lst, num, path + curNum, i + 1, target, curNum, curNum);
            } else {
                backtracking(lst, num, path + "+" + curNum, i + 1, target, curNum + cur, curNum);
                backtracking(lst, num, path + "-" + curNum, i + 1, target, cur - curNum, -curNum);
                backtracking(lst, num, path + "*" + curNum, i + 1, target, cur - prev + curNum * prev,
                        curNum * prev);
            }
        }
    }

    public static void main(String[] args) {
        L282ExpressionAddOperators l = new L282ExpressionAddOperators();
        System.out.println(l.addOperators("105",5));
    }
}
