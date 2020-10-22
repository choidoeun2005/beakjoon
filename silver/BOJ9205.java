package com.github.naruseon.beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 맥주 마시면서 걸어가기, silver 1

public class BOJ9205 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int CV_num = sc.nextInt();
            Pair home = new Pair(sc.nextInt(), sc.nextInt());
            Pair[] CV = new Pair[CV_num];
            for (int h = 0; h < CV_num; h++) {
                CV[h] = new Pair(sc.nextInt(), sc.nextInt());
            }
            Pair des = new Pair(sc.nextInt(), sc.nextInt());
            bfs(home, CV, des);
        }
        System.out.println(sb.toString());
    }

    public static int distance(Pair x, Pair y) {
        return Math.abs(x.x - y.x) + Math.abs(x.y - y.y);
    }

    public static void bfs(Pair home, Pair[] CV, Pair des) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(home);
        while(!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (distance(cur, des) <= 1000) {
                sb.append("happy").append("\n");
                return;
            }
            for (int i = 0; i < CV.length; i++) {
                if (distance(CV[i], cur) <= 1000) {
                    queue.offer(CV[i]);
                    CV[i] = new Pair(10000000, 10000000);
                }
            }
        }
        sb.append("sad").append("\n");
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
