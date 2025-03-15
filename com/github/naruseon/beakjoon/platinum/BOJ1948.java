package com.github.naruseon.beakjoon.platinum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int busy_roads = 0;
        ArrayList<Pair>[] graph = new ArrayList[N];
        ArrayList<Pair>[] backwards_graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            backwards_graph[i] = new ArrayList<>();
        }

        int[] ind = new int[N];
        Arrays.fill(ind, 0);

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt() - 1;
            int dest = sc.nextInt() - 1;
            int cost = sc.nextInt();
            ind[dest]++;
            graph[start].add(new Pair(dest, cost));
            backwards_graph[dest].add(new Pair(start, cost));
        }

        int s_city = sc.nextInt() - 1;
        int d_city = sc.nextInt() - 1;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(s_city);
        int[] max_dist = new int[N];
        int[] backwards_max_dist = new int[N];

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Pair next : graph[cur]) {
                max_dist[next.to] = Math.max(max_dist[next.to], max_dist[cur] + next.cost);
                ind[next.to]--;
                if (ind[next.to] == 0)
                    queue.offer(next.to);
            }
        }

        queue.offer(d_city);
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Pair next : backwards_graph[cur]) {
                if (backwards_max_dist[cur] + next.cost + max_dist[next.to] == max_dist[d_city]) {
//                    System.out.println(cur + " " + next.to + " " + next.cost);
                    busy_roads++;
                    if (!visited[next.to]) {
                        visited[next.to] = true;
                        queue.offer(next.to);
                    }
                    backwards_max_dist[next.to] = backwards_max_dist[cur] + next.cost;
                }
            }
        }

        System.out.println(max_dist[d_city]);
        System.out.println(busy_roads);

    }

    static class Pair {
        int to, cost;
        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
