package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// Z, silver 1

public class BOJ1074 {

    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();

        int y = sc.nextInt();
        int x = sc.nextInt();
        System.out.println(solve(level, x, y));
    }

    public static int solve(int level, int x, int y) {
        int size = (int) Math.pow(2, level);
        int cell = (int) Math.pow(4, level);
        if (level == 1) {
            int quad = getQuadrent(size, x, y);
            if (quad == 1) return cnt;
            if (quad == 2) return cnt + 1;
            if (quad == 3) return cnt + 2;
            if (quad == 4) return cnt + 3;
        }

        int quad = getQuadrent(size, x, y);

        if (quad == 1) {
            return solve(level - 1, x, y);
        } else if (quad == 2) {
            cnt += cell / 4;
            return solve(level - 1, x - size / 2, y);
        } else if (quad == 3) {
            cnt += cell / 4 * 2;
            return solve(level - 1, x, y - size / 2);
        } else if (quad == 4) {
            cnt += cell / 4 * 3;
            return solve(level - 1, x - size / 2, y - size / 2);
        }
        return -1;
    }

    public static int getQuadrent(int size, int x, int y) {
        float stdX = (size - 1) / 2f;
        float stdY = (size - 1) / 2f;
        if (x < stdX && y < stdY) return 1;
        if (x > stdX && y < stdY) return 2;
        if (x < stdX && y > stdY) return 3;
        if (x > stdX && y > stdY) return 4;
        return 0;
    }
}
