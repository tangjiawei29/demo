
package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class L390EliminationGame {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
//        作者：godweiyang
//        链接：https://leetcode-cn.com/problems/elimination-game/solution/mei-ri-suan-fa-day-85-tu-jie-suan-fa-yi-xing-dai-m/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    public static void main(String[] args) {
        L390EliminationGame l = new L390EliminationGame();
        for (int i = 1; i <= 25; i++) {
            System.out.println(i + ": " + l.lastRemaining(i));
        }

    }
}
