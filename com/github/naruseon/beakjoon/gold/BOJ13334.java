package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> list = new PriorityQueue<>(Comparator.comparingInt(p -> p.y));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            list.add(new Pair(a, b));
        }


        int d = Integer.parseInt(br.readLine());
        int max = 0;

        while (!list.isEmpty()) {
            Pair p = list.poll();
            pq.add(p.x);
            while (!pq.isEmpty()) {
                if (pq.peek() < p.y - d) pq.poll();
                else break;
            }
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
