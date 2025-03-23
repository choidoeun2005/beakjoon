package com.github.naruseon.beakjoon.platinum;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ6549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Pair> stack = new Stack<>();
        int N = sc.nextInt();
        while (N != 0) {
            long max = 0;
            for (int i = 0; i < N; i++) {
                int cur = sc.nextInt();
                if (stack.isEmpty()) {
                    stack.push(new Pair(i, cur));
                    continue;
                }

                while (cur < stack.peek().height) {
                    Pair last = stack.pop();
                    long width = i;
                    if (stack.size() != 0)
                        width -= stack.peek().index + 1;
                    max = Math.max(max, width * last.height);
                    if (stack.isEmpty()) break;
                }
                stack.push(new Pair(i ,cur));
            }
            while (!stack.isEmpty()) {
                Pair last = stack.pop();
                long width = N;
                if (stack.size() != 0)
                    width -= stack.peek().index + 1;
                max = Math.max(max, width * last.height);
            }
            System.out.println(max);
            N = sc.nextInt();
        }

    }

    static class Pair {
        long index, height;

        Pair(long index, long height) {
            this.height = height;
            this.index = index;
        }
    }
}