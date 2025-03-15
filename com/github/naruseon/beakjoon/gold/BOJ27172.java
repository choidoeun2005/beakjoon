package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        int[] sol = new int[1_000_001];
        boolean[] sol_check = new boolean[1_000_001];
        Arrays.fill(sol_check, false);
        Arrays.fill(sol, 0);

        for (int i = 0; i < N; i++) {
            sol_check[arr[i]] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = arr[i] * 2; j <= 1_000_000; j += arr[i]) {
                if (sol_check[j]) {
                    sol[j] -= 1;
                    sol[arr[i]] += 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(sol[arr[i]] + " ");
        }
    }
}
