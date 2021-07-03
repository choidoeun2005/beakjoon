package com.github.naruseon.beakjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

// 숨바꼭질 3, gold 5

public class BOJ13549 {
    static int[] dist = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;
        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int K) {

        return -1;
    }

    static class Pair {
        int cur, time;
        public Pair(int cur, int time) {
            this.cur = cur;
            this.time = time;
        }
    }
}
