package com.github.naruseon.beakjoon.silver;

import java.util.*;

// 케빈 베이컨의 6단계 법칙, silver 1

public class BOJ1389 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int M = sc.nextInt();
    static int[][] map = new int[N][N];
    static int[] visited = new int[N];

    public static void main(String[] args) {
        Pair2[] info = new Pair2[N];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            map[a][b] = 1;
            map[b][a] = 1;
        }
        for (int i = 0; i < N; i++) {
            info[i] = search(i);
            visited = new int[N];
        }
        Arrays.sort(info, (p1, p2) -> {
            if (p1.num != p2.num) {
                return Integer.compare(p1.num, p2.num);
            } else {
                return Integer.compare(p1.id, p2.id);
            }
        });
        System.out.println(info[0].id + 1);
    }

    public static Pair2 search(int start) {
        int cnt = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));
        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            int curid = cur.id;
            int curcnt = cur.cnt;
            visited[curid] = 1;
            for (int i = 0; i < N; i++) {
                if (map[curid][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    queue.offer(new Pair(i, curcnt + 1));
                    cnt += (curcnt + 1);
                }
            }
        }
        return new Pair2(start, cnt);
    }

    static class Pair {
        int id;
        int cnt;
        public Pair(int id, int cnt) {
            this.id = id;
            this.cnt = cnt;
        }
    }

    static class Pair2 {
        int id;
        int num;
        public Pair2(int id, int num) {
            this.id = id;
            this.num = num;
        }
    }
}
