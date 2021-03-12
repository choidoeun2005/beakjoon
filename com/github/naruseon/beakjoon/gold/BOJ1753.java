package com.github.naruseon.beakjoon.gold;

import java.util.*;

// 최단경로, gold 5

public class BOJ1753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt() - 1;
        List<Pair>[] info = (List<Pair>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            info[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int dest = sc.nextInt();
            int cost = sc.nextInt();
            info[from - 1].add(new Pair(dest - 1, cost));
        }

        boolean[] visited = new boolean[V];
        int[] res = new int[V];

        for (int i = 0; i < V; i++) {
            if (i == start) {
                res[i] = 0;
            } else {
                res[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            for (Pair next : info[cur.index]) {
                if (!visited[next.index] && res[next.index] > res[cur.index]+ next.cost) {
                    res[next.index] = res[cur.index] + next.cost;
                    pq.add(new Pair(next.index, res[next.index]));
                }
            }
            visited[cur.index] = true;
        }

        for (int i : res) {
            System.out.println((i == Integer.MAX_VALUE) ? "INF" : i);
        }
    }

    static class Pair {
        int index, cost;

        public Pair(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return cost + "";
        }
    }
}
