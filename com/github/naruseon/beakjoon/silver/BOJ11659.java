package com.github.naruseon.beakjoon.silver;

import java.util.Scanner;

// 구간 합 구하기 4, silver 3

public class BOJ11659 {
    static int[] tree;
    static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int tree_cap = (int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))) * 2;
        tree = new int[tree_cap];

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        createSegmentTree(0, N - 1, 1);
        for(int i = 0; i < M; i++) {
            int left = sc.nextInt() - 1;
            int right = sc.nextInt() - 1;
            System.out.println(sumSegmentTree(0, N - 1, 1, left, right));
        }
    }

    public static int createSegmentTree(int begin, int end, int node) {
        if (begin == end)
            return tree[node] = nums[begin];
        int mid = (begin + end) / 2;
        return tree[node] = createSegmentTree(begin, mid, node * 2) + createSegmentTree(mid + 1, end, node * 2 + 1);
    }

    public static int sumSegmentTree(int begin, int end, int node, int left, int right) {
        if (left > end || right < begin)
            return 0;
        if (left <= begin && end <= right)
            return tree[node];
        int mid = (begin + end) / 2;
        return sumSegmentTree(begin, mid, node * 2, left, right) + sumSegmentTree(mid + 1, end, node * 2 + 1, left, right);
    }
}
