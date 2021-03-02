package com.github.naruseon.beakjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토, silver 1

public class BOJ7569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int[][][] box = new int[z][y][x];
        int cnt = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int a = 0; a < z; a++) {
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    box[a][i][j] = sc.nextInt();
                }
            }
        }

        for (int a = 0; a < z; a++) {
            for (int h = 0; h < y; h++) {
                for (int w = 0; w < x; w++) {
                    if (box[a][h][w] == 1) queue.offer(new Pair(a, h, w));
                }
            }
        }


        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                Pair next = queue.poll();
                for (int i = 0; i < 6; i++) {
                    int nextX = next.x + new int[]{1, -1, 0, 0, 0, 0}[i];
                    int nextY = next.y + new int[]{0, 0, 1, -1, 0, 0}[i];
                    int nextZ = next.z + new int[]{0, 0, 0, 0, 1, -1}[i];
                    if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= x || nextY >= y || nextZ >= z)
                        continue;
                    if (box[nextZ][nextY][nextX] == -1 || box[nextZ][nextY][nextX] == 1)
                        continue;
                    box[nextZ][nextY][nextX] = 1;
                    queue.offer(new Pair(nextZ, nextY, nextX));
                }
            }
            cnt++;
        }


        for (int[][] i : box) {
            for (int[] j : i) {
                for (int h : j) {
                    if (h == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        System.out.println(cnt - 1);
    }

    static class Pair {
        int y, x, z;

        public Pair(int z, int y, int x) {
            this.y = y;
            this.x = x;
            this.z = z;
        }
    }
}

