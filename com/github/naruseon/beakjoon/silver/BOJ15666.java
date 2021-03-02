package com.github.naruseon.beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

// N과 M (12), silver 2

public class BOJ15666 {

    static int N, M;
    static int[] arr;
    static int[] selected;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        selected = new int[M];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        solve(0, 0);
    }

    public static void solve (int start, int depth) {
        if (depth == M) {
            for (int i : selected) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        int prev = -1;
        for (int i = start; i < N; i++) {
            if (arr[i] != prev) {
                prev = arr[i];
                selected[depth] = arr[i];
                solve(i, depth + 1);
            }
        }
    }
}
