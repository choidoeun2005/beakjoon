package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// RGB거리, silver 1

public class BOJ1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] info = new int[N][3];
        int[][] DP = new int[N][3];

        for (int i = 0; i < N; i++) {
            info[i][0] = sc.nextInt();
            info[i][1] = sc.nextInt();
            info[i][2] = sc.nextInt();
        }

        DP[0][0] = info[0][0];
        DP[0][1] = info[0][1];
        DP[0][2] = info[0][2];

        for (int i = 1; i < N; i++) {
            DP[i][0] = info[i][0] + Math.min(DP[i - 1][1], DP[i - 1][2]);
            DP[i][1] = info[i][1] + Math.min(DP[i - 1][0], DP[i - 1][2]);
            DP[i][2] = info[i][2] + Math.min(DP[i - 1][0], DP[i - 1][1]);
        }

        System.out.println(Math.min(Math.min(DP[N - 1][0], DP[N - 1][1]), DP[N - 1][2]));
    }
}
