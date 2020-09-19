package com.github.naruseon.beakjoon.silver;

// 색종이 만들기, silver 3

import java.util.Scanner;

public class BOJ2630 {

    static int blue = 0;
    static int white = 0;
    static int[][] paper;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        paper = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        DQ(0, 0, size);
        System.out.println(white);
        System.out.println(blue);
    }

    static void DQ(int x, int y, int size) {
        if (check(x, y, size)) {
            if (paper[x][y] == 0) white++;
            else blue++;
            return;
        }
        int newsize = size / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                DQ(x + i * newsize, y + j * newsize, newsize);
            }
        }
    }

    static boolean check(int x, int y, int size) {
        int std = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != std) {
                    return false;
                }
            }
        }
        return true;
    }
}
