package com.github.naruseon.beakjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// 큐, silver 4

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            String command = info[0];
            switch (command) {
                case "push":
                    q.push(Integer.parseInt(info[1]));
                    break;
                case "front":
                    System.out.println(q.isEmpty() ? -1 : q.getLast());
                    break;
                case "back":
                    System.out.println(q.isEmpty() ? -1 : q.getFirst());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "pop":
                    System.out.println(q.isEmpty() ? -1 : q.removeLast());
                    break;
                case "empty":
                    System.out.println(q.isEmpty() ? 1 : 0);
                    break;
            }
        }
    }
}
