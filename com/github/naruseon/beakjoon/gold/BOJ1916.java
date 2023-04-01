package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소비용 구하기, gold 5

public class BOJ1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Pair>[] info = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            info[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String busInfo = br.readLine();
            String[] busInfoArray = busInfo.split(" ");
            int cur = Integer.parseInt(busInfoArray[0]) - 1;
            int dest = Integer.parseInt(busInfoArray[1]) - 1;
            int cost = Integer.parseInt(busInfoArray[2]);
            info[cur].add(new Pair(dest, cost));
        }
        String startDest = br.readLine();
        String[] startDestSplit = startDest.split(" ");
        int start = Integer.parseInt(startDestSplit[0]) - 1;
        int dest = Integer.parseInt(startDestSplit[1]) - 1;

        System.out.println(dijkstra(info, start, dest, N));
    }

    static int dijkstra(List<Pair>[] info, int start, int final_dest, int N) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        q.add(new Pair(start, 0));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int cur = pair.dest;
            if (cur == final_dest)
                return dist[final_dest];
            for (Pair p : info[cur]) {
                if (dist[p.dest] > dist[cur] + p.cost) {
                    dist[p.dest] = dist[cur] + p.cost;
                    q.add(new Pair(p.dest, dist[p.dest]));
                }
            }
        }
        return -1;
    }

    static class Pair {
        int dest;
        int cost;
        public Pair(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
