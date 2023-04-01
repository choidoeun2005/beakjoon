package com.github.naruseon.beakjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 뱀과 사다리 게임, gold 5

public class BOJ16928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ladder = sc.nextInt();
        int snake = sc.nextInt();
        int tp = ladder + snake;

        int[] dest = new int[101]; // 1~100까지 담음
        int[] cost = new int[101]; // 비용
        for (int i = 0; i < 101; i++) {
            cost[i] = -1;
        }

        for (int i = 1; i <= 100; i++) {
            dest[i] = i;
        }

        for (int i = 0; i < tp; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            dest[from] = to;
        }

        Queue<Integer> q = new LinkedList();
        q.offer(1);
        cost[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                next = dest[next];
                if (cost[next] == -1) {
                    cost[next] = cost[cur] + 1;
                    q.offer(next);
                }
            }
        }
        System.out.println(cost[100]);
    }
}
