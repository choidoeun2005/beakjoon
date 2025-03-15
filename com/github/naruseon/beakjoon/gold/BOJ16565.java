package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16565 {
    public static void main(String[] args) throws IOException {
        int p = 10007;
        int[][] C = new int[49][49];
        C[0][0] = 1;
        C[1][0] = 1;
        C[1][1] = 1;
        for (int i = 2; i < 49; i++) {
            C[i][0] = 1;
            for (int j = 1; j < i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                C[i][j] %= p;
            }
            C[i][i] = 1;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 3) {
            System.out.println(0);
            return;
        }

        int q = N / 4;
        int ans = 0;
        int sign = 1;

        for (int i = 1; i <= q; i++) {
            ans += sign * (C[13][i] * C[52 - 4 * i][N - 4 * i]) % p;
            ans %= p;
            sign = -sign;
        }

        System.out.println((ans >= 0) ? ans : p + ans);
    }
}
