package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// 경로 찾기, silver 1

public class BOJ11403 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] graph = new int[size][size];

        int inf = 10000;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                graph[i][j] = sc.nextInt();
                if (graph[i][j] == 0) graph[i][j] = inf;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int h = 0; h < size; h++) {
                    if (graph[j][h] > graph[j][i] + graph[i][h]) {
                        graph[j][h] = graph[j][i] + graph[i][h];
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print((graph[i][j] == inf ? 0 : 1) + " ");
            }
            System.out.println();
        }
    }
}
