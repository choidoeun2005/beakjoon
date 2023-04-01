package com.github.naruseon.beakjoon.silver;

// 구간 합 구하기 5, silver 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String metaInfo = br.readLine();
        String[] metaInfoSplit = metaInfo.split(" ");
        int N = Integer.parseInt(metaInfoSplit[0]);
        int M = Integer.parseInt(metaInfoSplit[1]);
        int[][] list = new int[N][N];
        int[][] DP = new int[N][N];

        for (int i = 0; i < N; i++) {
            String rowInfo = br.readLine();
            String[] rowInfoSplit = rowInfo.split(" ");
            for (int j = 0; j < N; j++) {
                list[i][j] = Integer.parseInt(rowInfoSplit[j]);
            }
        }

        DP[0][0] = list[0][0];
        DP[0][1] = list[0][1] + DP[0][0];
        DP[1][0] = list[1][0] + DP[0][0];
        int startPoint = 0;
        while(startPoint < N) {
            for (int i = startPoint; i < N; i++) {
                if (startPoint == 0) {
                    if (i - 1 < 0) continue;
                    DP[startPoint][i] = DP[startPoint][i - 1] + list[startPoint][i];
                } else {
                    DP[startPoint][i] = DP[startPoint - 1][i] + DP[startPoint][i - 1] - DP[startPoint - 1][i - 1] + list[startPoint][i];
                }
            }

            for (int i = startPoint; i < N; i++) {
                if (startPoint == 0) {
                    if (i - 1 < 0) continue;
                    DP[i][startPoint] = DP[i - 1][startPoint] + list[i][startPoint];
                } else {
                    DP[i][startPoint] = DP[i][startPoint - 1] + DP[i - 1][startPoint] - DP[i - 1][startPoint - 1] + list[i][startPoint];
                }
            }
            startPoint++;
        }

        for (int i = 0; i < M; i++) {
            String ansInfo = br.readLine();
            String[] ansInfoSplit = ansInfo.split(" ");
            int x1 = Integer.parseInt(ansInfoSplit[0]) - 1;
            int y1 = Integer.parseInt(ansInfoSplit[1]) - 1;
            int x2 = Integer.parseInt(ansInfoSplit[2]) - 1;
            int y2 = Integer.parseInt(ansInfoSplit[3]) - 1;

            int ans = DP[x2][y2];
            if (x1 != 0) ans -= DP[x1 - 1][y2];
            if (y1 != 0) ans -= DP[x2][y1 - 1];
            if ((x1 != 0) && (y1 != 0)) ans += DP[x1 - 1][y1 - 1];
            System.out.println(ans);
        }
    }
}
