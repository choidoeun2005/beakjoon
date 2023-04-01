package com.github.naruseon.beakjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가장 긴 증가하는 부분 수열 5, platinum 5

public class BOJ14003 {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = fr.nextInt();
        }

        ArrayList<Integer> minValForLenOf = new ArrayList<>();

        minValForLenOf.add(0);
        minValForLenOf.add(numbers[0]);

        int[] DP = new int[N];
        DP[0] = 1;

        int maxLenIndex = 0;

        for (int i = 1; i < N; i++) {
            int cur = numbers[i];
            if (cur > minValForLenOf.get(minValForLenOf.size() - 1)) {
                maxLenIndex = i;
                DP[i] = minValForLenOf.size();
                minValForLenOf.add(cur);
                continue;
            }
            int left = 0;
            int right = minValForLenOf.size() - 1;
            int mid;
            boolean fullySearched = true;
            for (;;) {
                if (left == right - 1) break;
                mid = (left + right) / 2;
                if (cur > minValForLenOf.get(mid))
                    left = mid;
                else if (cur < minValForLenOf.get(mid))
                    right = mid;
                else {
                    DP[i] = mid;
                    fullySearched = false;
                    break;
                }
            }
            if (fullySearched) {
                minValForLenOf.set(right, cur);
                DP[i] = right;
            }
        }

        int LISLen = DP[maxLenIndex];
        int[] LIS = new int[LISLen];
        int nextLenToFind = LISLen;

        for (int i = maxLenIndex; i >= 0; i--) {
            if (DP[i] == nextLenToFind) {
                LIS[nextLenToFind - 1] = numbers[i];
                nextLenToFind--;
            }
            if (nextLenToFind == 0) break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(LISLen).append("\n");

        for (int i : LIS) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
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
