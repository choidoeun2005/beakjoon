package com.github.naruseon.beakjoon.silver;

import java.util.*;

// 트리의 부모 찾기, silver 2

public class BOJ11725 {
	static ArrayList<Integer>[] graph;
	static int N;
	static int[] visited;
	static int[] parents;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		graph = (ArrayList<Integer>[]) new ArrayList[N];
		visited = new int[N];
		parents = new int[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			int from = sc.nextInt() - 1;
			int to = sc.nextInt() - 1;
			graph[from].add(to);
			graph[to].add(from);
		}

		bfs(0);
		for (int i = 1; i < N; i++) {
			System.out.println(parents[i] + 1);
		}
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			ArrayList<Integer> arr = graph[cur];
			for (int i : arr) {
				if (visited[i] != 1) {
					queue.add(i);
					parents[i] = cur;
					visited[i] = 1;
				}
			}
		}
	}
}
