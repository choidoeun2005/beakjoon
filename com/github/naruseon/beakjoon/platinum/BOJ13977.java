package com.github.naruseon.beakjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ13977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long mod = 1_000_000_007;
        long[] fact = new long[4_000_001];
        fact[0] = 0;
        fact[1] = 1;
        for (long i = 2; i < 4_000_001; i++) {
            fact[(int) i] = (fact[(int) i - 1] * i) % mod;
        }

        int query = Integer.parseInt(br.readLine());
        for (int i = 0; i < query; i++) {
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int K = Integer.parseInt(info[1]);
            if (K == 0 || N == K) {
                System.out.println(1);
                continue;
            }
            long inv = (fact[K] * fact[N - K]) % mod;
            long inv_ans = 1;
            long target = mod - 2;
            while (target > 0) {
                if (target % 2 == 1) {
                    inv_ans = (inv_ans * inv) % mod;
                }
                inv = (inv * inv) % mod;
                target >>= 1;
            }

            long ans = (fact[N] * inv_ans) % mod;
            System.out.println(ans);
        }
    }
}
