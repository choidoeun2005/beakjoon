package com.github.naruseon.beakjoon.platinum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ11438 {
    static ArrayList<Integer>[] graph;
    static int[] level;
    static int[][] parents;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sp_len = (int) Math.ceil(Math.log(N - 1) / Math.log(2)) + 1;

        graph = new ArrayList[N];
        level = new int[N];
        parents = new int[sp_len][N];

        Arrays.fill(level, 0);
        for (int i = 0; i < sp_len; i++) {
            Arrays.fill(parents[i], -1);
        }

        parents[0][0] = -1;

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            graph[from].add(to);
            graph[to].add(from);
        }

        int M = sc.nextInt();

        boolean[] keep_search = new boolean[N];
        Arrays.fill(keep_search, true);

        for (int i : graph[0]) {
            tree(i, 0);
        }


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

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(find_lca(sc.nextInt() - 1, sc.nextInt() - 1) + 1);
            sb.append("\n");
        }

        System.out.println(sb);


//
//        for (int[] i : parents) {
//            System.out.println(Arrays.toString(i));
//        }
////        System.out.println(Arrays.toString(level));

    }

    private static void tree(int node, int parent) {
        level[node] = level[parent] + 1;
        parents[0][node] = parent;

        for (int i : graph[node]) {
            if (!(i == parent)) {
                tree(i, node);
            }
        }
    }

    private static int find_nth_parent(int node, int n) {
        if (n == 0) return node;
        int point = (int) Math.ceil(Math.log(n) / Math.log(2));
        int t = 1 << point;
        point++;
        while (t >= 1) {
//            System.out.println(t + " " + point);
            if ((t & n) != 0) {
//                System.out.println(" match");
                node = parents[point - 1][node];
            }
            t >>= 1;
            point--;
        }
        return node;
    }

    static int find_lca(int a, int b) {
        if (level[a] != level[b]) {
            if (level[a] > level[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            int level_diff = level[b] - level[a];
            b = find_nth_parent(b, level_diff);
        }

        int l = 0;
        int r = level[a];
        int mid = (l + r) / 2;


        while (l < r) {
            if (find_nth_parent(a, mid) == find_nth_parent(b, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
            mid = (l + r) / 2;
        }

        return find_nth_parent(a, mid);
    }
}
