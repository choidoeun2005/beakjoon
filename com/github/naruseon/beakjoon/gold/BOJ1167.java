package com.github.naruseon.beakjoon.gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 트리의 지름, gold 3

public class BOJ1167 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		List<Node>[] arr = (List<Node>[]) new ArrayList[V];
		
		for (int i = 0; i < V; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			int cur = sc.nextInt() - 1;
			while (true) {
				int num = sc.nextInt();
				if (num == -1)
					break;
				int cost = sc.nextInt();
				arr[cur].add(new Node(num - 1, cost));
			}
		}
		int[] dist = new int[V];
		dist = bfs(arr, 0, V);
		int S = 1;
		for (int i = 1; i < V; i++) {
			if (dist[S] < dist[i]) S = i;
		}
		dist = bfs(arr, S, V);
		Arrays.sort(dist);
		System.out.println(dist[V - 1]);
	}

	public static int[] bfs(List<Node>[] arr, int start, int V) {
		int[] visited = new int[V];
		int[] dist = new int[V];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (Node node : arr[cur]) {
				int des = node.des;
				int D = node.dist;
				if (visited[des] != 1) {
					visited[des] = 1;
					queue.add(des);
					dist[des] = dist[cur] + D;
				}
			}
		}
		return dist;
	}

	static class Node {
		int des;
		int dist;

		public Node(int des, int dist) {
			this.des = des;
			this.dist = dist;
		}
	}
}
