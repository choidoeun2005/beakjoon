package com.github.naruseon.beakjoon.platinum;

import java.io.*;
import java.util.*;

public class BOJ1185 {

    static int N, P;
    static int[] cost;
    static boolean[] visited;
    static List<Pair>[] w;
    static int min = Integer.MAX_VALUE;

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        P = Integer.parseInt(input[1]);

        cost = new int[N + 1];
        visited = new boolean[N + 1];
        w = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            w[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, cost[i]);
        }

        for (int i = 0; i < P; i++) {
            input = br.readLine().split(" ");
            int S = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            int L = Integer.parseInt(input[2]);

            w[S].add(new Pair(E, cost[S] + cost[E] + 2 * L));
            w[E].add(new Pair(S, cost[S] + cost[E] + 2 * L));
        }

        long res = getMST() + min;

        bw.write(res + "\n");
        bw.flush();

    }

    public static long getMST() {

        long sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(1, 0));

        while (!pq.isEmpty()) {

            Pair pair = pq.poll();

            if (visited[pair.n])
                continue;

            visited[pair.n] = true;
            sum += pair.w;

            for (Pair np : w[pair.n]) {
                if (!visited[np.n]) {
                    pq.offer(np);
                }
            }

        }

        return sum;
    }

    static class Pair implements Comparable<Pair> {

        int n, w;

        Pair(int n, int w) {
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Pair o) {

            return w - o.w;
        }
    }

}