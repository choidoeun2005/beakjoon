package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 한 node를 head로 하는 sub-tree를 생각한다.

public class BOJ2533 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[][] DP;
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        Arrays.fill(visited, false);
        DP = new int[N][2];

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            DP[i][0] = 0;
            DP[i][1] = 1;
        }

        for (int i = 0; i < N-1; i++) {
            String[] info = br.readLine().split(" ");
            int a = Integer.parseInt(info[0]) - 1;
            int b = Integer.parseInt(info[1]) - 1;

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(0);
        System.out.println(Math.min(DP[0][0], DP[0][1]));
    }

    static void dfs(int node){
        visited[node] = true;
        for(int i = 0; i < graph[node].size(); i++) {
            int next_node = graph[node].get(i);
            if (visited[next_node]) continue;
            dfs(next_node);
            DP[node][0] += DP[next_node][1];
            DP[node][1] += Math.min(DP[next_node][0], DP[next_node][1]);
        }
    }
}
