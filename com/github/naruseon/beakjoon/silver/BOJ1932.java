package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// 정수 삼각형, silver 1

public class BOJ1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] triangle = new int[N][N];
        int[][] DP = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        DP[0][0] = triangle[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    DP[i][j] = DP[i - 1][0] + triangle[i][j];
                else if (j == i)
                    DP[i][j] = DP[i - 1][j - 1] + triangle[i][j];
                else DP[i][j] = Math.max(DP[i - 1][j], DP[i - 1][j - 1]) + triangle[i][j];
            }
        }

        int ans = -1;
        for (int i : DP[N - 1]) {
            ans = Math.max(ans, i);
        }

        System.out.println(ans);
    }
}
