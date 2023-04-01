package com.github.naruseon.beakjoon.gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질 3, gold 5

public class BOJ13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {
        boolean[] visited = new boolean[100_001];
        Arrays.fill(visited, false);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(K, 0));
        while (true) {
            Pair pair = q.poll();
            int cur = pair.cur;
            int time = pair.time;
            visited[cur] = true;
            if (cur == N)
                return time;
            if (cur % 2 == 0 && !visited[cur / 2])
                q.add(new Pair(cur / 2, time));
            if (cur + 1 <= 100_000 && !visited[cur + 1])
                q.add(new Pair(cur + 1, time + 1));
            if (cur - 1 >= 0 && !visited[cur - 1])
                q.add(new Pair(cur - 1, time + 1));
        }
    }

    static class Pair {
        int cur, time;

        public Pair(int cur, int time) {
            this.cur = cur;
            this.time = time;
        }
    }
}


