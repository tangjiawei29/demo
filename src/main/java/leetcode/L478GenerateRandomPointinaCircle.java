package leetcode;

import java.util.Random;

public class L478GenerateRandomPointinaCircle {

    double x, y, r;
    Random random = new Random();

    public L478GenerateRandomPointinaCircle(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {

        while(true) {
            double xx = 2 * random.nextDouble() - 1;
            double yy = 2 * random.nextDouble() - 1;
            if (xx * xx + yy * yy <= 1) {
                return new double[] {xx * r + x, yy * r + y};
            }
        }
    }

    public static void main(String[] args) {
        L478GenerateRandomPointinaCircle l = new L478GenerateRandomPointinaCircle(1.0, 0, 0);
        double[] a = l.randPoint();
        for (double v : a) {
            System.out.println(v);
        }
    }

}
