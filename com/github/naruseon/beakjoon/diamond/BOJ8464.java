package com.github.naruseon.beakjoon.diamond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Non-Squarefree Numbers, diamond 5

public class BOJ8464 {
    static int[] mobius = new int[173207];
    // 173206 = sqrt(3*10^10)

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        mobius[1] = 1;
        long N = fr.nextLong();

        // 돌려보니까 1 <= n <= 5 인 범위에서 right범위를 넘어서는 N이 나옴
        // 이상치이니까 따로 처리를 해주자

       if (N == 1) {
           System.out.println(4);
           return;
       }

       if (N == 2) {
           System.out.println(8);
           return;
       }

        if (N == 3) {
            System.out.println(9);
            return;
        }

        if (N == 4) {
            System.out.println(12);
            return;
        }

        if (N == 5) {
            System.out.println(16);
            return;
        }


        for (int i = 1; i < 173207; i++) {
            for (int j = i * 2; j < 173207; j += i) {
                mobius[j] -= mobius[i];
            }
        }

        // N 이하의 squareful integer 의 개수가 n이 되도록 하는 N을 구해야 함.
        // squareful integer의 밀도는 약 0.4
        // 10개 탐색하면 그중에 4개 찾으므로 10개 찾으려면 25개 탐색해야 함 (N = 2.5n)
        // 넉넉잡고 N = 3n을 max치로 잡자


        long ans = 0;
        long left = 0;
        long right = N * 3;
        while (left < right - 1) {
            long mid = (left + right) / 2;
            if (countNonSquareFree(mid) < N)
                left = mid;
            else right = mid;
            ans = right;
        }
        System.out.println(ans);
    }

    static long countNonSquareFree(long n) {
        long cnt = 0;
        for (long i = 2; i * i <= n; i++) {
            cnt -= mobius[(int) i] * (n / (i * i));
        }
        return cnt;
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
