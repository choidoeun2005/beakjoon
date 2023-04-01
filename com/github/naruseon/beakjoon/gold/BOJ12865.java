package com.github.naruseon.beakjoon.gold;

// 평범한 배낭, gold 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NK = br.readLine();
        String[] NK_split = NK.split(" ");
        int N = Integer.parseInt(NK_split[0]); // 물품 수
        int K = Integer.parseInt(NK_split[1]); // 최대 무게

        int[][] DP = new int[N + 1][K + 1]; // 행이 물품 수, 열이 무게
        int[] d_weight = new int[N];
        int[] profit = new int[N];

        for (int i = 0; i < N; i++) {
            String item_info = br.readLine();
            String[] item_info_split = item_info.split(" ");
            int ith_weight = Integer.parseInt(item_info_split[0]);
            int ith_profit = Integer.parseInt(item_info_split[1]);
            d_weight[i] = ith_weight;
            profit[i] = ith_profit;
        }

        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= K; w++) {
               if (i == 0 || w == 0) {
                   DP[i][w] = 0;
               } else if (d_weight[i - 1] <= w) {
                   DP[i][w] = Math.max(profit[i - 1] + DP[i - 1][w - d_weight[i - 1]], DP[i - 1][w]);
               } else { // 넣고자 하는 물건이 무게를 초과할 경우
                   DP[i][w] = DP[i - 1][w];
               }
            }
        }

        System.out.println(DP[N][K]);
    }
}
