package com.github.naruseon.beakjoon.silver;

// 연결 요소의 개수, silver 2

import java.util.*;

public class BOJ11724 {

    static int[][] graph;
    static int point;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        point = sc.nextInt();
        int line = sc.nextInt();
        graph = new int[point][point];

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < line; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x - 1][y - 1] = 1;
            graph[y - 1][x - 1] = 1;
            set.add(x - 1);
            set.add(y - 1);
        }

        int cnt = 0;

        for (int i = 0; i < point; i++) {
            if (!set.contains(i)) cnt++;
        }

        for (int i = 0; i < point; i++) {
            for (int j = 0; j < point; j++) {
                if (graph[i][j] == 1) {
                    bfs(i);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int next = queue.poll();
            for (int i = 0; i < point; i++) {
                if (graph[next][i] == 1) {
                    graph[next][i] = 0;
                    queue.offer(i);
                }
            }
        }
    }
}
