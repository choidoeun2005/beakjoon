package com.github.naruseon.beakjoon;

import java.util.*;

// N°ú  M (5), silver 3
// TODO

public class BOJ15654 {
	
	static boolean[] isused;
	static int N, M;
	static int[] arr;
	static int[] selected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		isused = new boolean[10001];
		selected = new int[M];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		solve(0);
	}
	
	public static void solve(int k) {
		if (k == M) {
			for (int i : selected) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!isused[i]) {
				isused[i] = true;
				selected[k] = arr[i];
				solve(k + 1);
				isused[i] = false;
			}
		}
	}
}
