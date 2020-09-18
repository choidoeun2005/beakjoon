package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// 동전 0, silver 1

public class BOJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int def = sc.nextInt();
        int[] coin = new int[num];
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            coin[i] = sc.nextInt();
        }

        for (int i = coin.length - 1; i >= 0; i--) {
            if (def == 0) break;
            if (def - coin[i] < 0) continue;
            cnt += def / coin[i];
            def %= coin[i];
        }

        System.out.println(cnt);
    }
}
