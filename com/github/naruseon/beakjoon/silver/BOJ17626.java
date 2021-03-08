package com.github.naruseon.beakjoon.silver;

// Four Squares, silver 5

import java.util.Scanner;

public class BOJ17626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N + 1];
        DP[0] = 0;
        DP[1] = 1;

        int min;

        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, DP[temp]);
            }
            DP[i] = min + 1;
        }
        System.out.println(DP[N]);
    }
}