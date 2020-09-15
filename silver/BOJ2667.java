package com.github.naruseon.beakjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지번호붙이기, sliver 1

public class BOJ2667 {


    static int[][] graph;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new int[N][N];
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String _apart = br.readLine();
            char[] apart = _apart.toCharArray();
            for (int j = 0; j < N; j++) {
                if (apart[j] == '1')
                    graph[i][j] = 1;
                else
                    graph[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && visited[i][j] == 0) {
                    arr.add(numApt(i, j));
                    cnt++;
                }
            }
        }
        if (cnt == 0) {
            System.out.println("0\n0");
            return;
        }
        Collections.sort(arr);
        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static int numApt(int y, int x) {
        int cnt = 1;
        visited[y][x] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(y, x));
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = pair.x + dx[i];
                int nextY = pair.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || visited[nextY][nextX] == 1 || graph[nextY][nextX] == 0) {
                    continue;
                }
                queue.offer(new Pair(nextY, nextX));
                visited[nextY][nextX] = 1;
                cnt++;
            }
        }
        return cnt;
    }
}

class Pair {
    int x, y;
    public Pair(int y, int x) {
        this.x = x;
        this.y = y;
    }
}