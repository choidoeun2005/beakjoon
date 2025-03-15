package com.github.naruseon.beakjoon.platinum;

import java.util.*;

public class BOJ5719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        while (N != 0 && M != 0) {
            int[] min_dist = new int[N];
            Arrays.fill(min_dist, Integer.MAX_VALUE);
            int[] backwards_dist = new int[N];
            Arrays.fill(backwards_dist, Integer.MAX_VALUE);
            boolean[][] prohibited = new boolean[N][N];

            ArrayList<Pair>[] graph = new ArrayList[N];
            ArrayList<Pair>[] backwards_graph = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                backwards_graph[i] = new ArrayList<>();
            }

            int s_city = sc.nextInt();
            int d_city = sc.nextInt();

            for (int i = 0; i < M; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();

                graph[from].add(new Pair(to, cost));
                backwards_graph[to].add(new Pair(from, cost));
            }

            boolean[] visited = new boolean[N];
            PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
            queue.offer(new Pair(s_city, 0));
            min_dist[s_city] = 0;
            while (!queue.isEmpty()) {
                Pair cur = queue.poll();
                if (visited[cur.to]) continue;
                visited[cur.to] = true;
                for (Pair next : graph[cur.to]) {
                   if (min_dist[next.to] > min_dist[cur.to] + next.cost) {
                       min_dist[next.to] = min_dist[cur.to] + next.cost;
                       queue.offer(new Pair(next.to, min_dist[next.to]));
                   }
                }
            }

//            System.out.println(Arrays.toString(min_dist));

            LinkedList<Integer> q = new LinkedList<>();
            q.offer(d_city);
            backwards_dist[d_city] = 0;
            boolean[] visited_2  = new boolean[N];
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (Pair next : backwards_graph[cur]) {
                    if (backwards_dist[cur] + next.cost + min_dist[next.to] == min_dist[d_city]) {
                        backwards_dist[next.to] = next.cost + backwards_dist[cur];
                        prohibited[next.to][cur] = true;
                        if (!visited_2[next.to]) {
                            q.offer(next.to);
                            visited_2[next.to] = true;
                        }
                    }
                }
            }



            boolean[] visited_3 = new boolean[N];
            queue.offer(new Pair(s_city, 0));
            int[] final_dist = new int[N];
            Arrays.fill(final_dist, Integer.MAX_VALUE);
            final_dist[s_city] = 0;
            while (!queue.isEmpty()) {
                Pair cur = queue.poll();
                if (visited_3[cur.to]) continue;
                visited_3[cur.to] = true;
                for (Pair next : graph[cur.to]) {
                    if (prohibited[cur.to][next.to])
                        continue;
                    if (final_dist[next.to] > final_dist[cur.to] + next.cost) {
                        final_dist[next.to] = final_dist[cur.to] + next.cost;
                        queue.offer(new Pair(next.to, final_dist[next.to]));
                    }
                }
            }

            System.out.println(final_dist[d_city] == Integer.MAX_VALUE ? -1 : final_dist[d_city]);

            N = sc.nextInt();
            M = sc.nextInt();
        }
    }
    static class Pair {
        int to, cost;
        Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
