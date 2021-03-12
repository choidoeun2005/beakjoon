package com.github.naruseon.beakjoon.gold;

import java.util.Scanner;

// 미세먼지 안녕!, gold 5

public class BOJ17144 {
    static int R, C, T;
    static int AP1, AP2;
    static int[][] map;
    static int[][] direction; // form of 4-digit binary string. up / down / left / right
    static int[][] addedVal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        map = new int[R][C];
        direction = new int[R][C];
        addedVal = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                direction[i][j] = 0b1111;
            }
        }
        for (int i = 0; i < C; i++) {
            direction[0][i] ^= 0b1000;
        }
        for (int i = 0; i < C; i++) {
            direction[R - 1][i] ^= 0b0100;
        }
        for (int i = 0; i < R; i++) {
            direction[i][C - 1] ^= 0b0001;
        }
        for (int i = 0; i < R; i++) {
            direction[i][0] ^= 0b0010;
        }

        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                if (AP1 == 0) AP1 = i;
                else AP2 = i;
            }
        }

        direction[AP1][1] ^= 0b0010;
        direction[AP2][1] ^= 0b0010;
        if (AP1 > 0) direction[AP1 - 1][0] ^= 0b0100;
        if (AP2 > 0) direction[AP1 + 1][0] ^= 0b1000;

        for (int i = 0; i < T; i++) {
            disperse();
            purify();
        }

        int ans = 0;

        for (int[] arr : map) {
            for (int i : arr) {
                ans += i;
            }
        }

        System.out.println(ans + 2);
    }

    public static void purify() {
        for (int i = AP1 - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < AP1; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[AP1][i] = map[AP1][i - 1];
        }
        map[AP1][1] = 0;

        for (int i = AP2 + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }

        for (int i = 1; i < C; i++) {
            map[R - 1][i - 1] = map[R - 1][i];
        }

        for (int i = R - 1; i > AP2; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            map[AP2][i] = map[AP2][i - 1];
        }

        map[AP2][1] = 0;
    }

    public static void disperse() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int amount = map[i][j] / 5;
                if (i > 0 && i < R - 1 && j < C - 1 && j > 1) {
                    addedVal[i][j + 1] += amount;
                    addedVal[i + 1][j] += amount;
                    addedVal[i - 1][j] += amount;
                    addedVal[i][j - 1] += amount;
                    map[i][j] -= (map[i][j] / 5) * 4;
                    continue;
                }
                int dir = 0;
                int info = direction[i][j];

                if ((info & 1) == 1) {
                    dir++;
                    addedVal[i][j + 1] += amount;
                }
                if (((info >>= 1) & 1) == 1) {
                    dir++;
                    addedVal[i][j - 1] += amount;
                }
                if (((info >>= 1) & 1) == 1) {
                    dir++;
                    addedVal[i + 1][j] += amount;
                }
                if ((info >> 1 & 1) == 1) {
                    dir++;
                    addedVal[i - 1][j] += amount;
                }

                map[i][j] -= (map[i][j] / 5) * dir;
            }
        }

        addedVal[AP1][0] = 0;
        addedVal[AP2][0] = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += addedVal[i][j];
                addedVal[i][j] = 0;
            }
        }
    }
}