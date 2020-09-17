package com.github.naruseon.beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        int[][] box = new int[height][width];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                box[i][j] = sc.nextInt();
            }
        }

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (box[h][w] == 1) queue.offer(new Pair(h, w));
            }
        }
    }

    static class Pair {
        int height, width;

        public Pair(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }
}


