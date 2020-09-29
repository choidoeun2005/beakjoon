package com.github.naruseon.beakjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 적록색약, gold 5

public class BOJ10026 {

    static int normalcnt = 0;
    static int colorcnt = 0;
    static int N;
    static char[][] grid1;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new char[N][N];
        grid1 = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] c = sc.next().toCharArray();
            grid[i] = c.clone();
            grid1[i] = c.clone();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'R')
                    grid[i][j] = 'G';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 'X') {
                    bfs(grid, i, j);
                    colorcnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid1[i][j] != 'X') {
                    bfs(grid1, i, j);
                    normalcnt++;
                }
            }
        }

        System.out.println(normalcnt + " " + colorcnt);
    }

    public static void bfs(char[][] grid, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        char std = grid[x][y];
        grid[x][y] = 'X';
        queue.offer(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = pair.x + new int[]{1, -1, 0, 0}[i];
                int nextY = pair.y + new int[]{0, 0, 1, -1}[i];
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }
                if (grid[nextX][nextY] == 'X') {
                    continue;
                }
                if (grid[nextX][nextY] == std) {
                    queue.offer(new Pair(nextX, nextY));
                    grid[nextX][nextY] = 'X';
                }
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
