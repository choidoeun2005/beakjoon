package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS, gold 5

public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int N = first.length();
        int M = second.length();

        if (N == 0 || M == 0) {
            System.out.println(0);
            return;
        }

        char[] first_char = first.toCharArray();
        char[] second_char = second.toCharArray();

        int[][] DP = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (i == 0 || j == 0) DP[i][j] = 0;
                else if (first_char[i - 1] == second_char[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        System.out.println(DP[N][M]);
    }
}
