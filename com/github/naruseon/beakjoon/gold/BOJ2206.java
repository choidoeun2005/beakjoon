package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 부수고 이동하기, gold 3

public class BOJ2206 {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        boolean[][] map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] line = fr.next().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = line[j] == '0';
            }
        }

        int[][][] dist = new int[N][M][2];
        // [][][0] 벽뚫안함
        // [][][1] 벽뚫함
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j][0] = Integer.MAX_VALUE;
                dist[i][j][1] = Integer.MAX_VALUE;
            }
        }

        dist[0][0][0] = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int ans = -1;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0,  false));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                ans = Math.min(dist[N - 1][M - 1][0], dist[N - 1][M - 1][1]);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                if (next_x >= 0 && next_x < N & next_y >= 0 && next_y < M) {
                    if (map[next_x][next_y]) { // 벽뚫 안해도 되면
                        if (dist[next_x][next_y][cur.brokeWall ? 1 : 0] == Integer.MAX_VALUE) {
                            dist[next_x][next_y][cur.brokeWall ? 1 : 0] = dist[cur.x][cur.y][cur.brokeWall ? 1 : 0] + 1;
                            q.offer(new Pair(next_x, next_y, cur.brokeWall));
                        }
                    } else { // 벽뚫 해야 하면
                        if (!cur.brokeWall) {
                            if (dist[next_x][next_y][1] == Integer.MAX_VALUE) {
                                dist[next_x][next_y][1] = dist[cur.x][cur.y][0] + 1;
                                q.offer(new Pair(next_x, next_y, true));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    private static class Pair {
        int x, y;
        boolean brokeWall;

        Pair(int x, int y, boolean brokeWall) {
            this.x = x;
            this.y = y;
            this.brokeWall = brokeWall;
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
