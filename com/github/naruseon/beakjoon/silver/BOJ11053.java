package com.github.naruseon.beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

// 가장 긴 증가하는 부분 수열, silver 2

public class BOJ11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }
        int[] DP = new int[N];
        Arrays.fill(DP, 1);
        int ans = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }
            ans = Math.max(ans, DP[i]);
        }
        System.out.println(ans);
    }
}
