package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L754ReachNumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        for (int i = 0; ; i++) {
            sum += i;
            if (sum >= target && sum % 2 == target % 2)
                return i;
        }
    }

    public static void main(String[] args) {
        int n = 15;
        List<List<Integer>> list = new ArrayList();
        list.add(Arrays.asList(new Integer[] {0}));

        for (int i = 1; i <= n; i++) {
            List<Integer> lst = new ArrayList();
            for (int m : list.get(list.size() - 1)) {
                lst.add(m + i);
                lst.add(m - i);
            }
            Collections.sort(lst);
            list.add((List<Integer>) lst.stream().distinct().collect(Collectors.toList()));
        }

        for (int i = 0; i < list.size(); i++)
            System.out.println(i + " " + list.get(i));
//        list.forEach(t-> System.out.println(t));

    }
}
