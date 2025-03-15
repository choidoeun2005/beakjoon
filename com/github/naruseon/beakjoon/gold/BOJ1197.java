package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V, E;
        String[] info = br.readLine().split(" ");
        V = Integer.parseInt(info[0]);
        E = Integer.parseInt(info[1]);

        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        ArrayList<Pair>[] tree = new ArrayList[V];

        for (int i = 0; i < E; i++) {
            String[] info1 = br.readLine().split(" ");
            int from = Integer.parseInt(info1[0]) - 1;
            int to = Integer.parseInt(info1[1]) - 1;
            int cost = Integer.parseInt(info1[2]);

            Pair p = new Pair(to, cost);
            tree[from].add(p);
        }

        int ans = 0;

        Queue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));

        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (visited[p.dest]) continue;
            visited[p.dest] = true;
            ans += p.cost;
            if (!visited[p.dest]) {


            }
        }

    }

    static class Pair{
        int dest, cost;
        public Pair(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
