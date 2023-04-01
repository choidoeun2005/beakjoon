package com.github.naruseon.beakjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 평균, bronze 1

public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        int sum = 0;
        int max = 0;
        for (String s : info) {
            int cur = Integer.parseInt(s);
            max = Math.max(cur, max);
            sum += cur;
        }

        double sumD = sum;

        System.out.println(100 * (sumD) / (max * N));
    }
}
