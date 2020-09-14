package com.github.naruseon.beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질, sliver 1

public class BOJ1697 {

    static Queue<Integer> queue = new LinkedList<>();
    static int[] visited = new int[100001];
    static Scanner sc = new Scanner(System.in);
    static int cur = sc.nextInt();
    static int def = sc.nextInt();

    public static void main(String[] args) {

        queue.offer(cur);
        visited[cur] = 1;

        System.out.println(bfs());
    }

    public static int bfs() {
        queue.offer(cur);
        visited[cur] = 1;

        while(!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == def) return visited[cur] - 1;

            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                queue.offer(cur - 1);
                visited[cur - 1] = visited[cur] + 1;
            }
            if (cur + 1 <= 100000 && visited[cur + 1] == 0) {
                queue.offer(cur + 1);
                visited[cur + 1] = visited[cur] + 1;
            }
            if (cur * 2 <= 100000 && visited[cur * 2] == 0) {
                queue.offer(cur * 2);
                visited[cur * 2] = visited[cur] + 1;
            }
        }
        return 0;
    }
}
