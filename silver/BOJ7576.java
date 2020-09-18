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
        int cnt = 0;
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

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                Pair next = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = next.width + new int[]{1, -1, 0, 0}[i];
                    int nextY = next.height + new int[]{0, 0, 1, -1}[i];
                    if (nextX < 0 || nextY < 0 || nextX >= width || nextY >= height)
                        continue;
                    if (box[nextY][nextX] == -1 || box[nextY][nextX] == 1)
                        continue;
                    box[nextY][nextX] = 1;
                    queue.offer(new Pair(nextY, nextX));
                }
            }
            cnt++;
        }

        for (int[] i : box) {
            for (int j : i) {
                if (j == 0) {
                    System.out.println("-1");
                    return;
                }
            }
        }
        System.out.println(cnt - 1);
    }

    static class Pair {
        int height, width;

        public Pair(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }
}


