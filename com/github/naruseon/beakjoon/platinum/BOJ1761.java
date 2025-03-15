package com.github.naruseon.beakjoon.platinum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1761 {
    static ArrayList<Pair>[] graph;
    static int[] level;
    static int[] dist_from_root;
    static int[][] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sp_len = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        parents = new int[sp_len][N];

        graph = new ArrayList[N];
        level = new int[N];
        dist_from_root = new int[N];

        Arrays.fill(level, 0);
        Arrays.fill(dist_from_root, 0);

        for (int i = 0; i < sp_len; i++) {
            for (int j = 0; j < N; j++) {
                parents[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Pair>();
        }

        for (int i = 0; i < N - 1; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();
            graph[from].add(new Pair(to, cost));
            graph[to].add(new Pair(from, cost));
        }

        for (Pair p : graph[0]) {
            set_tree(p, 0);
        }

        boolean[] keep_search = new boolean[N];
        Arrays.fill(keep_search, true);
        keep_search[0] = false;

        for (int i = 1; i < sp_len; i++) {
            for (int j = 1; j < N; j++) {
                if (!keep_search[j]) {
                    continue;
                }
                if (parents[i - 1][j] == -1) {
                    keep_search[j] = false;
                    continue;
                }
                parents[i][j] = parents[i - 1][parents[i - 1][j]];
            }
        }

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            System.out.println(dist(a, b));
        }
    }

    private static void set_tree(Pair p, int parent) {
        parents[0][p.to] = parent;
        level[p.to] = level[parent] + 1;
        dist_from_root[p.to] += dist_from_root[parent] + p.cost;

        for (Pair next : graph[p.to]) {
            if (next.to != parent) {
                set_tree(next, p.to);
            }
        }
    }

    private static int nth_parent(int node, int n) {
        int bit = 1 << 15;
        int pos = 15;
        while (bit >= 1) {
            if ((bit & n) != 0) {
                node = parents[pos][node];
            }
            bit >>= 1;
            pos -= 1;
        }

        return node;
    }

    private static int dist(int a, int b) {
        int ans = 0;
        if (level[a] > level[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int new_b = nth_parent(b, level[b] - level[a]);
        ans += dist_from_root[b] - dist_from_root[new_b];

        int l = 0;
        int r = level[a];
        int mid = (l + r) / 2;

        while (l < r) {

            if (nth_parent(a, mid) == nth_parent(new_b, mid)) {
                r = mid;
            } else l = mid + 1;

            mid = (l + r) / 2;
        }

        int lca = nth_parent(a, mid);

        ans += dist_from_root[a] + dist_from_root[new_b] - 2 * dist_from_root[lca];

        return ans;
    }

    static class Pair {
        int to, cost;

        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
