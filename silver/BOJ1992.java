package com.github.naruseon.beakjoon.silver;

// silver 1, 쿼드트리

import java.util.Scanner;

public class BOJ1992 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                video[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        DQ(video, 0, 0, N);
        System.out.println(sb.toString());
    }

    public static void DQ(int[][] video, int x, int y, int size) {
        if (isCorrect(video, x, y, size)) {
            sb.append(video[x][y]);
        } else {
            sb.append("(");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    DQ(video, x + i * (size / 2), y + j * (size / 2), size / 2);
                }
            }
            sb.append(")");
        }
    }

    public static boolean isCorrect(int[][] video, int x, int y, int size) {
        int std = video[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != std) return false;
            }
        }
        return true;
    }
}
