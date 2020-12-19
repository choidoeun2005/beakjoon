package com.github.naruseon.beakjoon;

import java.util.*;

// ½ºÆ¼Ä¿, silver 2

public class BOJ9465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] stickers = new int[2][N];
			for (int j = 0; j < N; j++) {
				stickers[0][j] = sc.nextInt();
			}
			for (int j = 0; j < N; j++) {
				stickers[1][j] = sc.nextInt();
			}
			stickers[0][1] += stickers[1][0];
			stickers[1][1] += stickers[0][0];
			for (int j = 2; j < N; j++) {
				stickers[0][j] += Math.max(stickers[1][j - 2], stickers[1][j - 1]);
				stickers[1][j] += Math.max(stickers[0][j - 2], stickers[0][j - 1]);
			}
			sb.append(Math.max(stickers[0][N - 1], stickers[1][N - 1]));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
