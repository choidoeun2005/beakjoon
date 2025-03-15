package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2166 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        double ans = 0;

        double prev_x, prev_y, x = 0, y = 0;

        double xPivot = 0, yPivot = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (i == 0) {
                xPivot = Double.parseDouble(line.split(" ")[0]);
                yPivot = Double.parseDouble(line.split(" ")[1]);
                continue;
            }

            if (i == 1) {
                x = Double.parseDouble(line.split(" ")[0]);
                y = Double.parseDouble(line.split(" ")[1]);
                continue;
            }

            prev_x = x;
            prev_y = y;
            x = Double.parseDouble(line.split(" ")[0]);
            y = Double.parseDouble(line.split(" ")[1]); // 3 points determined

            Pair v1 = new Pair(prev_x - xPivot, prev_y - yPivot);
            Pair v2 = new Pair(x - xPivot, y - yPivot);

            ans += crossProduct(v1, v2);
        }

        System.out.printf("%.1f", ((double) Math.abs(Math.round(ans * 10 / 2)) / 10));
    }

    static double crossProduct(Pair x, Pair y) {
        return x.x * y.y - x.y * y.x;
    }

    static class Pair {
        double x, y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
