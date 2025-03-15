package com.github.naruseon.beakjoon.gold;

import java.io.*;

public class BOJ2448 {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int N = a / 3;
        int step = 1;
        while (N != 1) {
            N /= 2;
            step++;
        }

        boolean[][] ans = new boolean[a][(int) (5 * Math.pow(2, step - 1) + Math.pow(2, step - 1) - 1)];

        for (int i = 0; i < step; i++) {

            if (i == 0) {
                ans[0][a - 1] = true; // *
                ans[1][a - 2] = true;
                ans[1][a] = true; // * *
                ans[2][a - 3] = true;
                ans[2][a - 2] = true;
                ans[2][a - 1] = true;
                ans[2][a] = true;
                ans[2][a + 1] = true; // *****
            } else {
                int LposH = a - 1 - 3 * (int) Math.pow(2, i - 1);
                int RposH = a - 1 + 3 * (int) Math.pow(2, i - 1);
                int LposLB = LposH - (3 * (int) Math.pow(2, i - 1) - 1);
                int LposRB = LposH + (3 * (int) Math.pow(2, i - 1) - 1);
                int RposLB = RposH - (3 * (int) Math.pow(2, i - 1) - 1);
                int RposRB = RposH + (3 * (int) Math.pow(2, i - 1) - 1);
                int posYStart = 3 * (int) (Math.pow(2, i - 1));
                int posYEnd = 3 * (int) (Math.pow(2, i)) - 1;

                for (int h = posYStart; h <= posYEnd; h++) {
                    for (int x = LposLB; x <= LposRB; x++) {
                        ans[h][x] = ans[h - (int) Math.pow(2, i - 1) * 3][x + (int) Math.pow(2, i - 1) * 3];
                    }

                    for (int x = RposLB; x <= RposRB; x++) {
                        ans[h][x] = ans[h - (int) Math.pow(2, i - 1) * 3][x - (int) Math.pow(2, i - 1) * 3];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                sb.append(ans[i][j] ? "*" : " ");
            }
            if (i != ans.length - 1) sb.append("\n");
        }

        System.out.println(sb);
    }
}
