package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS 2, gold 4

public class BOJ9252 {
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

        int LCSLen = DP[N][M];
        int[] LCSFirstIndex = new int[LCSLen];
        int foundLCSLen = 0;
        int i = N;
        int j = M;
        while (foundLCSLen < LCSLen) {
            if (DP[i][j] == DP[i - 1][j])
                i = i - 1;
            else if (DP[i][j] == DP[i][j - 1])
                j = j - 1;
            else {
                i = i - 1;
                j = j - 1;
                LCSFirstIndex[LCSLen - foundLCSLen - 1] = i;
                foundLCSLen++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k : LCSFirstIndex)
            sb.append(first_char[k]);

        System.out.println(LCSLen);
        System.out.println(sb);

    }
}
