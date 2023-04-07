package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분 수열, gold 4

public class BOJ11054 {
    static int[] num;
    static int N;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = fr.nextInt();
        }

        int[] bitonicLen = new int[N];

        for (int i = 0; i < N; i++) {
            bitonicLen[i] = LISLen(i) + reverseLISLen(i) - 1;
        }

        int ans = 1;

        for (int i : bitonicLen)
            ans = Math.max(ans, i);

        System.out.println(ans);
    }

    private static int LISLen(int turningPoint) {
        if (turningPoint == 0) return 1;

        ArrayList<Integer> minValForLenOf = new ArrayList<>();
        minValForLenOf.add(0);
        minValForLenOf.add(num[0]);
        for (int i = 1; i <= turningPoint; i++) {
            int left = 0;
            int right = minValForLenOf.size() - 1;
            int mid;
            if (num[i] > minValForLenOf.get(right)) {
                minValForLenOf.add(num[i]);
                continue;
            }
            boolean fullySearched = true;
            for (;;) {
                if (left == right - 1) break;
                mid = (left + right) / 2;
                if (num[i] > minValForLenOf.get(mid))
                    left = mid;
                else if (num[i] < minValForLenOf.get(mid))
                    right = mid;
                else {
                    fullySearched = false;
                    break;
                }
            }

            if (fullySearched)
                minValForLenOf.set(right, num[i]);
        }
        return minValForLenOf.size() - 1;
    }

    private static int reverseLISLen(int turningPoint) {
        if (turningPoint == N - 1) return 1;

        ArrayList<Integer> minValForLenOf = new ArrayList<>();
        minValForLenOf.add(0);
        minValForLenOf.add(num[N - 1]);
        for (int i = N - 2; i >= turningPoint; i--) {
            int left = 0;
            int right = minValForLenOf.size() - 1;
            int mid;
            if (num[i] > minValForLenOf.get(right)) {
                minValForLenOf.add(num[i]);
                continue;
            }
            boolean fullySearched = true;
            for (;;) {
                if (left == right - 1) break;
                mid = (left + right) / 2;
                if (num[i] > minValForLenOf.get(mid))
                    left = mid;
                else if (num[i] < minValForLenOf.get(mid))
                    right = mid;
                else {
                    fullySearched = false;
                    break;
                }
            }

            if (fullySearched)
                minValForLenOf.set(right, num[i]);
        }
        return minValForLenOf.size() - 1;
    }

    private static class FastReader {
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
    }
}
