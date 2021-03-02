package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// 1, 2, 3 더하기, silver 3

public class BOJ9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < T; j++) {
            int size = sc.nextInt();
            int[] DP = new int[size + 1];
            if (size == 1) {
                sb.append(1).append("\n"); continue;
            }
            if (size == 2) {
                sb.append(2).append("\n"); continue;
            }
            DP[1] = 1;
            DP[2] = 2;
            DP[3] = 4;
            for (int i = 4; i <= size; i++) {
                DP[i] = DP[i - 3] + DP[i - 2] + DP[i - 1];
            }
            sb.append(DP[size]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
