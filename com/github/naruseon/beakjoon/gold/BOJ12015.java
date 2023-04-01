package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 가장 긴 증가하는 부분 수열 2, gold 2

public class BOJ12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(info[i]);
        }

        ArrayList<Integer> minValForLenOf = new ArrayList<>();

        minValForLenOf.add(0);
        minValForLenOf.add(numbers[0]);

        int curMaxLen = 1;

        for (int i = 1; i < N; i++) {
            int cur = numbers[i];
            if (cur > minValForLenOf.get(minValForLenOf.size() - 1)) {
                curMaxLen++;
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
                    fullySearched = false;
                    break;
                }
            }
            if (fullySearched)
                minValForLenOf.set(right, cur);
        }

        System.out.println(curMaxLen);
    }
}
