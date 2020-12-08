package com.github.naruseon.beakjoon;

import java.util.Scanner;

// 테트로미노, gold 5

public class BOJ14500 {
	static Scanner sc = new Scanner(System.in);
	static int height = sc.nextInt();
	static int width = sc.nextInt();
	static int[][] map = new int[height][width];
	static int max;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited = new boolean[height][width];

	public static void main(String[] args) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				dfs(i, j, 0, 0);
				Exception(i, j);
				
			}
		}

		System.out.println(max);
	}

	public static void dfs(int x, int y, int depth, int sum) {
		 
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }
 
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
 
            if (nextX < 0 || nextY < 0 || nextX >= height || nextY >= width) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            visited[nextX][nextY] = true;
            dfs(nextX, nextY, depth + 1, sum + map[nextX][nextY]);
            visited[nextX][nextY] = false;
 
        }
 
    }

	public static void Exception(int x, int y) {
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if (wing <= 2)
                return;
            
            if (nextX < 0 || nextY < 0 || nextX >= height || nextY >= width) {
                wing--;
                continue;
            }
            min = Math.min(min, map[nextX][nextY]);
            sum = sum + map[nextX][nextY];
        }
        
        if (wing == 4) {
            sum = sum - min;
        }
        max = Math.max(max, sum);
    }
}
