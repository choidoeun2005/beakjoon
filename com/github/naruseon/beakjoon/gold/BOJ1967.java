package com.github.naruseon.beakjoon.gold;

import java.io.*;
import java.util.*;

// 트리의 지름, gold 4

public class BOJ1967 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int node = fr.nextInt();
        ArrayList<Pair>[] tree = new ArrayList[node];
        for (int i = 0; i < node; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < node - 1; i++) {
            int from = fr.nextInt() - 1;
            int to = fr.nextInt() - 1;
            int cost = fr.nextInt();
            Pair pair1 = new Pair(to, cost);
            tree[from].add(pair1);
            Pair pair2 = new Pair(from, cost);
            tree[to].add(pair2);
        }

        Queue<Pair> q = new LinkedList<>();
        int[] dist = new int[node];
        Arrays.fill(dist, -1);
        Pair start = new Pair(0, 0);
        q.add(start);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            dist[cur.to] = cur.cost;
            for (Pair p : tree[cur.to]) {
                if (dist[p.to] == -1) {
                    q.add(new Pair(p.to, p.cost + cur.cost));
                }
            }
        }

        int tempFarIndex = -1;
        int tempMaxDist = -1;
        for (int i = 0; i < node; i++) {
            if (tempMaxDist < dist[i]) {
                tempMaxDist = dist[i];
                tempFarIndex = i;
            }
        }

        Queue<Pair> q1 = new LinkedList<>();
        int[] dist1 = new int[node];
        Arrays.fill(dist1, -1);
        Pair start1 = new Pair(tempFarIndex, 0);
        q1.add(start1);
        while (!q1.isEmpty()) {
            Pair cur = q1.poll();
            dist1[cur.to] = cur.cost;
            for (Pair p : tree[cur.to]) {
                if (dist1[p.to] == -1) {
                    q1.add(new Pair(p.to, p.cost + cur.cost));
                }
            }
        }

        int maxDist = -1;
        for (int i : dist1) {
            maxDist = Math.max(maxDist, i);
        }

        System.out.println(maxDist);

    }



    private static class Pair {
        int to, cost;
        public Pair(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}
