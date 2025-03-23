package com.github.naruseon.beakjoon.gold;

import java.util.Scanner;
import java.util.Stack;

public class BOJ2812 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        String[] info = sc.next().split("");
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(info[i]);
        }
        int i = 0;
        boolean c = true;
        while ((N-- > 0) && c) {
            int cur = num[i++];
            if (!stack.isEmpty())
                while (cur > stack.peek()) {
                    stack.pop();
                    K--;
                    if (K == 0) {
                        c = false;
                        break;
                    }
                    if (stack.isEmpty()) break;
                }
            stack.push(cur);
        }
        N++;
        while (N-- > 0)
            stack.push(num[i++]);

        int[] ans = new int[stack.size()];

        for (int a = 0; a < ans.length; a++) {
            ans[ans.length - a - 1] = stack.pop();
        }

        for (int a = 0; a < ans.length - K; a++)
            System.out.print(ans[a]);
    }
}
