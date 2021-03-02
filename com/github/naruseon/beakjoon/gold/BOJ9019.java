package com.github.naruseon.beakjoon.gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// DSLR, gold 5

public class BOJ9019 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int start = sc.nextInt();
            int des = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            String[] cmd = new String[10000];
            boolean[] visited = new boolean[10000];
            Arrays.fill(cmd, "");
            Arrays.fill(visited, false);
            queue.offer(start);

            while (!queue.isEmpty() && !visited[des]) {
                int cur = queue.poll();
                int D = (cur * 2) % 10000;
                int S = (cur == 0) ? 9999 : cur - 1;
                int L = (cur % 1000) * 10 + cur / 1000;
                int R = (cur / 10) + (cur % 10) * 1000;
                visited[cur] = true;
                if (!visited[D]) {
                    visited[D] = true;
                    queue.offer(D);
                    cmd[D] = cmd[cur] + "D";
                }
                if (!visited[S]) {
                    visited[S] = true;
                    queue.offer(S);
                    cmd[S] = cmd[cur] + "S";
                }
                if (!visited[L]) {
                    visited[L] = true;
                    queue.offer(L);
                    cmd[L] = cmd[cur] + "L";
                }
                if (!visited[R]) {
                    visited[R] = true;
                    queue.offer(R);
                    cmd[R] = cmd[cur] + "R";
                }
            }
            sb.append(cmd[des]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
