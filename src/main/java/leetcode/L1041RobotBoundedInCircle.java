package leetcode;

public class L1041RobotBoundedInCircle {
    public boolean isRobotBounded(String i) {
        int dir = 0;
        int x = 0;
        int y = 0;
        for (char c : i.toCharArray()) {
            if (c == 'L') {
                dir = dir == 3 ? 0 : dir + 1;
            } else if (c == 'R') {
                dir = dir == 0 ? 3 : dir - 1;
            } else {
                if (dir == 0) y++;
                else if (dir == 1) x--;
                else if (dir == 2) y--;
                else x++;
            }
        }
        return (x == y && y == 0) || (dir != 0);
    }
}
