package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// 계단 오르기, silver 3

public class BOJ2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stair = new int[N];
        int[] DP = new int[N];
        for (int i = 0; i < N; i++) {
            stair[i] = sc.nextInt();
        }
        DP[0] = stair[0];
        if (N == 1) {
            System.out.println(DP[0]);
            return;
        }
        DP[1] = Math.max(stair[0] + stair[1], stair[1]);
        if (N == 2) {
            System.out.println(DP[1]);
            return;
        }
        DP[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

        for (int i = 3; i < N; i++) {
            DP[i] = Math.max(DP[i - 2] + stair[i], DP[i - 3] + stair[i - 1] + stair[i]);
        }
        System.out.println(DP[N - 1]);
    }
}
