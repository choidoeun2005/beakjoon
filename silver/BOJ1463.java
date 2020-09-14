package com.github.naruseon.beakjoon.silver;

import java.util.*;

// 1로 만들기, sliver 3

public class BOJ1463 {
    static Scanner sc = new Scanner(System.in);
    static int goal = sc.nextInt();
    static int[] info = new int[goal + 1];

    public static void main(String[] args) {

        Arrays.fill(info, goal);

        info[0] = 0;
        info[1] = 0;

        if (goal == 1) {
            System.out.println(0);
            return;
        }

        if (goal == 2 || goal == 3) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i < goal; i++) {
            if (i * 3 <= goal) info[i * 3] = Math.min(info[i] + 1, info[i * 3]);
            if (i * 2 <= goal) info[i * 2] = Math.min(info[i] + 1, info[i * 2]);
            info[i + 1] = Math.min(info[i] + 1, info[i + 1]);
        }
        System.out.println(info[goal]);
    }
}