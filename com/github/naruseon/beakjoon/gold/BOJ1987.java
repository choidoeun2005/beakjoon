package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 알파벳, gold 4
// TODO

public class BOJ1987 {
    static int R, C;
    static char[][] map;
    static int best = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] info = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = info[j];
            }
        }

        boolean[] visited = new boolean[26]; // 65 = A
        Arrays.fill(visited, false);


        dfs(0, 0, visited, 0);

        System.out.println(best);

    }

    static void dfs(int r, int c, boolean[] visited, int step) {
        if (visited[map[r][c] - 65]) {
            best = Math.max(best, step);
            return;
        }
        best = Math.max(best, step);
        visited[map[r][c] - 65] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            if (0 <= r + dx[i] && r + dx[i] < R && 0 <= c + dy[i] && c + dy[i] < C) {
                dfs(r + dx[i], c + dy[i], visited, step + 1);
            }
        }
        visited[map[r][c] - 65] = false;
    }
}
