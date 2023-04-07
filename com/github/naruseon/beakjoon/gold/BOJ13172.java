package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Σ, gold 4

public class BOJ13172 {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int mod = 1_000_000_007;
        int M = fr.nextInt();
        long ans = 0;
        for (int i = 0; i < M; i++) {
            int N = fr.nextInt();
            int S = fr.nextInt();
            ans += toMod(S, N);
        }
        System.out.println(ans % mod);
    }

    private static long toMod(long a, long b) {
        int mod = 1_000_000_007;
        int powerCnt = 1_000_000_007 - 2;
        long newB = 1;

        while (powerCnt > 0) {
            if (powerCnt % 2 != 0) {
                newB = (newB * b) % mod;
            }
            b = (b * b) % mod;
            powerCnt /= 2;
        }

        return (a * newB) % mod;
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
