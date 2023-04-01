package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 행렬 제곱, gold 4

public class BOJ10830 {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        long B = fr.nextLong();
        int[][] mat = new int[N][N];
        int[][] ans = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = fr.nextInt();
            }
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                ans[i][j] = (i == j) ? 1 : 0;

        while (B >= 1) {
            if (B % 2 != 0) ans = matMultiply(ans, mat, N);
            mat = matMultiply(mat, mat, N);
            B /= 2;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]);
                if (j != N - 1) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[][] matMultiply(int[][] mat1, int[][] mat2, int N) {
        int[][] ans = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                ans[i][j] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ans[i][j] += (mat1[i][k] * mat2[k][j]) % 1000;
                }
                ans[i][j] %= 1000;
            }
        }

        return ans;
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
}
