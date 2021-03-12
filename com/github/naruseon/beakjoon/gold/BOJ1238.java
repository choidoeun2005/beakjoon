package com.github.naruseon.beakjoon.gold;

import java.util.*;

// 파티, gold 3

public class BOJ1238 {
    static int N, M, X;
    static List<Node>[] info1;
    static List<Node>[] info2;
    static int[] dist1;
    static int[] dist2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt() - 1;
        info1 = (ArrayList<Node>[]) new ArrayList[N];
        info2 = (ArrayList<Node>[]) new ArrayList[N];
        dist1 = new int[N];
        dist2 = new int[N];

        for (int i = 0; i < N; i++) {
            info1[i] = new ArrayList<>();
            info2[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();
            info1[from].add(new Node(to, cost));
            info2[to].add(new Node(from, cost));
        }

        dist2 = dijkstra(X, 0);
        dist1 = dijkstra(X, 1);

        int ans = -1;

        for (int i = 0; i < N; i++) {
            if (ans < dist1[i] + dist2[i]) {
                ans = dist1[i] + dist2[i];
            }
        }

        System.out.println(ans);
    }

    public static int[] dijkstra(int start, int state) {
        List<Node>[] a;
        a = (state == 0) ? info1 : info2;
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        visited[start] = true;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : a[cur.index]) {
                if (!visited[next.index] && dist[next.index] > dist[cur.index] + next.cost) {
                    dist[next.index] = dist[cur.index] + next.cost;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
            visited[cur.index] = true;
        }
        return dist;
    }

    static class Node {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
