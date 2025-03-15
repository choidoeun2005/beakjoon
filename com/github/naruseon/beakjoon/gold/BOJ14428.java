package com.github.naruseon.beakjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ14428 {
    static int[] arr;
    static int[] tree;
    static int min = Integer.MAX_VALUE;
    static int minIdx;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
        }
        int leafs = (int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))) * 2;
        tree = new int[leafs];
        int M = sc.nextInt();
        init(1, N, 1);
        for (int i = 0; i < M; i++) {
            int p = sc.nextInt();
            if (p == 1) {
                update(1, N, 1, sc.nextInt(), sc.nextInt());
            } else {
                find(1, N, sc.nextInt(), sc.nextInt(), 1);
                System.out.println(minIdx);
                min = Integer.MAX_VALUE;
            }
        }
    }

    private static int init(int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return tree[index];
        }
        int mid = (start + end) / 2;
        tree[index] = Math.min(init(start, mid, index * 2), init(mid + 1, end, index * 2 + 1));
        return tree[index];
    }

    private static void update(int start, int end, int index, int arrIndex, int value) {
        if (start == end && end == arrIndex) {
            tree[index] = value;
            while (index > 1) {
                index >>= 1;
                tree[index] = Math.min(tree[index * 2], tree[index * 2 + 1]);
            }
            return;
        }
        int mid = (start + end) / 2;
        if (arrIndex > mid) update(mid + 1, end, index * 2 + 1, arrIndex, value);
        else update(start, mid, index * 2, arrIndex, value);
    }

    private static void find(int start, int end, int l, int r, int index) {
        int mid = (start + end) / 2;
        if (start == l && end == r) {
            if (min > tree[index]) {
                min = tree[index];
                while (index * 2 < tree.length) {
                    if (tree[index * 2] == tree[index]) {
                        index = index * 2;
                        end = mid;

                    } else if (tree[index * 2 + 1] == tree[index]){
                        index = index * 2 + 1;
                        start = mid + 1;
                    } else break;
                    mid = (start + end) / 2;
                }
                minIdx = start;
            }
            return;
        }
        if (l <= mid) {
            if (mid < r) {
                find(start, mid, l, mid, index * 2);
                find(mid + 1, end, mid + 1, r, index * 2 + 1);
            } else find(start, mid, l, r, index * 2);
        } else find(mid + 1, end, l, r, index * 2 + 1);
    }
}
