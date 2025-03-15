package com.github.naruseon.beakjoon.alps;

import java.util.Scanner;

public class BOJ32867 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;
        int[] keys = new int[N];
        for (int i = 0; i < N; i++) {
            keys[i] = sc.nextInt();
        }

        int min = keys[0];
        int max = keys[0];
        for (int key : keys) {
            if (min > key) {
                min = key;
                if (max - min >= K) {
                    ans++;
                    max = min;
                }
            }
            if (max < key) {
                max = key;
                if (max - min >= K) {
                    ans++;
                    min = max;
                }
            }
        }

        System.out.println(ans);
    }
}
