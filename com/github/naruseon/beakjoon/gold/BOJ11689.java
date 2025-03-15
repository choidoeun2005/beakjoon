package com.github.naruseon.beakjoon.gold;

import java.util.Scanner;

public class BOJ11689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        int lim = (int) Math.ceil(Math.sqrt(N));
        long ans = 1;
        for (int i = 2; i <= lim; i++) {
            int cnt = 0;
            while (N % i == 0) {
                cnt++;
                N /= i;
            }
            if (cnt > 0) {
                ans *= Math.pow(i, cnt - 1) * (i - 1);
            }

        }
        if (N != 1) {
            ans *= (N - 1);
        }

        System.out.println(ans);
    }
}
