package com.github.naruseon.beakjoon.gold;

import java.util.*;

// 특정한 최단 경로, gold 4

public class BOJ1504 {
    static List<Node>[] info;
    static int N, E;
    static int[] dist1, dist2, dist3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        info = (ArrayList<Node>[]) new ArrayList[N];

        dist1 = new int[N];
        dist2 = new int[N];
        dist3 = new int[N];

        for (int i = 0; i < N; i++) {
            dist1[i] = Integer.MAX_VALUE;
            dist2[i] = Integer.MAX_VALUE;
            dist3[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < N; i++) {
            info[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();
            info[from].add(new Node(to, cost));
            info[to].add(new Node(from, cost));
        }

        int V1 = sc.nextInt() - 1;
        int V2 = sc.nextInt() - 1;

        dist1[0] = 0;
        dist2[V1] = 0;
        dist3[V2] = 0;

        int V1toV2 = dijkstra(V1, V2);
        long case1 = dijkstra(0, V1) + V1toV2 + dijkstra(V2, N - 1);
        long case2 = dijkstra(0, V2) + V1toV2 + dijkstra(V1, N - 1);

        if (V1toV2 >= Integer.MAX_VALUE || case1 >= Integer.MAX_VALUE || case2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(case1, case2));
    }

    public static int dijkstra(int start, int dest) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : info[cur.index]) {
                if (dist[next.index] > dist[cur.index] + next.cost) {
                    dist[next.index] = dist[cur.index] + next.cost;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist[dest];
    }

    static class Node {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
