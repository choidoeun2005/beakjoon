package com.github.naruseon.beakjoon.silver;

// 2 x n 타일링, silver 3

import java.util.Scanner;

public class BOJ11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] DP = new int[size + 1];
        if (size <= 2) {
            System.out.println(size);
            return;
        }
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i <= size; i++) {
            DP[i] = DP[i - 2] % 10007 + DP[i - 1] % 10007;
        }
        System.out.println(DP[size] % 10007);
    }
}
