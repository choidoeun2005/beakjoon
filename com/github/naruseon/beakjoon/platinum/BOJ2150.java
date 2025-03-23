package com.github.naruseon.beakjoon.platinum;

import java.lang.reflect.Array;
import java.util.*;

public class BOJ2150 {
    static PriorityQueue<ArrayList<Integer>> answer;
    static PriorityQueue<Integer> temp;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] backwards_graph;
    static Stack<Integer> stack = new Stack<>();
    static boolean[] visited_1;
    static boolean[] visited_2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        visited_1 = new boolean[V];
        visited_2 = new boolean[V];
        graph = new ArrayList[V];
        backwards_graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
            backwards_graph[i] = new ArrayList<>();
        }

        answer = new PriorityQueue<>(Comparator.comparingInt(arr -> arr.get(0)));
        temp = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            graph[from].add(to);
            backwards_graph[to].add(from);
        }

        for (int i = 0; i < V; i++) {
            if (!visited_1[i])
                dfs(i);
        }
//        System.out.println(stack.toString());

        while (!stack.isEmpty()) {
            int cur = stack.pop();
//            System.out.println("cur " + cur);
            back_dfs(cur);
            ArrayList<Integer> arr = new ArrayList<>();
            while (!temp.isEmpty()) {
                int i = temp.poll();
                arr.add(i);
            }
            if (arr.size() > 0)
                answer.offer(arr);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");

        while (!answer.isEmpty()) {
            ArrayList<Integer> arr = answer.poll();
            for (int i : arr) {
                sb.append(i + 1).append(" ");
            }
            sb.append("-1");
            if (answer.size() != 0)
                sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited_1[start] = true;
        ArrayList<Integer> connected = graph[start];
        for (int next : connected) {
            if (!visited_1[next])
                dfs(next);
        }
        stack.push(start);
    }

    public static void back_dfs(int start) {
        if (visited_2[start]) return;
        visited_2[start] = true;
        ArrayList<Integer> connected = backwards_graph[start];
        for (int next : connected) {
            if (!visited_2[next])
                back_dfs(next);
        }
        temp.offer(start);
    }
}
