package com.github.naruseon.beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

// N과 M, silver 2

public class BOJ15663 {

    static int N, M;
    static int[] arr;
    static boolean[] isused;
    static int[] selected;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        isused = new boolean[N];
        selected = new int[M];

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        solve(0, 0);
    }

    public static void solve(int start, int depth) {
        if (depth == M) {
            for (int i : selected) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (!isused[i] && !(prev == arr[i])) {
                isused[i] = true;
                selected[depth] = arr[i];
                prev = arr[i];
                solve(i + 1, depth + 1);
                isused[i] = false;
            }
        }
    }
}
