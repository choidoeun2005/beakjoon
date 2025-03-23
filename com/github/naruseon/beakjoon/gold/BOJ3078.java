package com.github.naruseon.beakjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ3078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer>[] q = new LinkedList[21];
        for (int i = 0; i < 21; i++) {
            q[i] = new LinkedList<>();
        }

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            int len = name.length();
            if (q[len].isEmpty()) {
                q[len].offer(i);
            }
            if (q[len].peek() < i - K) {
                q[len].poll();
            }
        }
    }
}
