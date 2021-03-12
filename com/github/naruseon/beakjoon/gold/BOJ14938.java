package com.github.naruseon.beakjoon.gold;

import java.util.*;

// 서강그라운드, gold 4

public class BOJ14938 {
    static int[] items;
    static int N, M, R;
    static List<Node>[] info;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        items = new int[N];
        info = (ArrayList<Node>[]) new ArrayList[N];
        for (int i = 0; i < N; i++) {
            info[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            items[i] = sc.nextInt();
        }
        for (int i = 0; i < R; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();
            info[from].add(new Node(to, cost));
            info[to].add(new Node(from, cost));
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, find(i));
        }

        System.out.println(ans);

    }

    public static int find(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        boolean[] visited = new boolean[N];
        int[] dist = new int[N];
        visited[start] = true;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node next : info[cur.index]) {
                if (!visited[next.index] && dist[next.index] > dist[cur.index] + next.cost) {
                    dist[next.index] = dist[cur.index] + next.cost;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
            visited[cur.index] = true;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (dist[i] <= M) ans += items[i];
        }

        return ans;
    }

    static class Node {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
