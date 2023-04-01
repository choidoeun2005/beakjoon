package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 내려가기, gold 5

public class BOJ2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] DP = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int first = Integer.parseInt(line[0]);
            int second = Integer.parseInt(line[1]);
            int third = Integer.parseInt(line[2]);
            map[i][0] = first;
            map[i][1] = second;
            map[i][2] = third;
        }

        DP[0][0] = map[0][0];
        DP[0][1] = map[0][1];
        DP[0][2] = map[0][2];

        for (int j = 1; j < N; j++) {
            DP[j][0] = map[j][0] + Math.max(DP[j - 1][0], DP[j - 1][1]);
            DP[j][1] = map[j][1] + Math.max(DP[j - 1][0], Math.max(DP[j - 1][1], DP[j - 1][2]));
            DP[j][2] = map[j][2] + Math.max(DP[j - 1][1], DP[j - 1][2]);
        }
        System.out.print(Math.max(DP[N - 1][0], Math.max(DP[N - 1][1], DP[N - 1][2])) + " ");

        for (int j = 1; j < N; j++) {
            DP[j][0] = map[j][0] + Math.min(DP[j - 1][0], DP[j - 1][1]);
            DP[j][1] = map[j][1] + Math.min(DP[j - 1][0], Math.min(DP[j - 1][1], DP[j - 1][2]));
            DP[j][2] = map[j][2] + Math.min(DP[j - 1][1], DP[j - 1][2]);
        }

        System.out.print(Math.min(DP[N - 1][0], Math.min(DP[N - 1][1], DP[N - 1][2])));
    }
}
