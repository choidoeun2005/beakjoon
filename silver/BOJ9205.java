package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// TODO

// 맥주 마시면서 걸어가기, silver 1

public class BOJ9205 {
    public static void main(String[] args) {
        boolean check = true;
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int store = sc.nextInt();
            Pair[] info = new Pair[store + 2];
            for (int j = 0; j < info.length; j++) {
                info[j] = new Pair(sc.nextInt(), sc.nextInt());
            }
            for (int j = 0; j < store + 1; j++) {
                if (distance(info[j], info[j + 1]) > 1000) check = false;
            }
            if (check) sb.append("happy").append("\n"); else sb.append("sad").append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int distance(Pair x, Pair y) {
        return Math.abs(x.x - y.x) + Math.abs(x.y - y.y);
    }

    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
