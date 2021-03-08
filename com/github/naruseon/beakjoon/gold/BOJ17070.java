package com.github.naruseon.beakjoon.gold;

import java.util.Scanner;

// 파이프 옮기기 1, gold 5

public class BOJ17070 {
    static int[][] graph;
    static int N;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        if (graph[N - 1][N - 1] == 1) {
            System.out.println("0");
            return;
        }
        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    public static void dfs(int state, int x, int y) { // 0 : horizontal / 1 : vertical / 2 : diagonal
        if (x == N - 1 && y == N - 1) {
            cnt++;
            return;
        }
        if (state == 0) {
            if (x + 1 < N)
                if (graph[y][x + 1] == 0) {
                    dfs(0, x + 1, y);
                }
        } else if (state == 1) {
            if (y + 1 < N)
                if (graph[y + 1][x] == 0) {
                    dfs(1, x, y + 1);
                }
        } else if (state == 2){
            if (x + 1 < N)
                if (graph[y][x + 1] == 0) {
                    dfs(0, x + 1, y);
                }
            if (y + 1 < N)
                if (graph[y + 1][x] == 0) {
                    dfs(1, x, y + 1);
                }
        }
        if (x + 1 < N && y + 1 < N)
            if (graph[y + 1][x] == 0 && graph[y][x + 1] == 0 && graph[y + 1][x + 1] == 0) {
                dfs(2, x + 1, y + 1);
            }
    }
}