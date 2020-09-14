package com.github.naruseon.beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 바이러스, sliver 3

public class BOJ2606 {

    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int M = sc.nextInt();
    static int[][] graph = new int[N][N];
    static int[] visited = new int[N];
    static int cnt = 0;

    public static void main(String[] args) {
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a - 1][b - 1] = 1;
            graph[b - 1][a - 1] = 1;
        }

        bfs(0);

        System.out.println(cnt);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 1;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int next = queue.poll();
            for (int i = 0; i < N; i++) {
                if (graph[next][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(i);
                    cnt++;
                }
            }
        }
    }
}
