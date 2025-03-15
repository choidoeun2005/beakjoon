package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2042 {
    static long[] arr;
    static long[] tree;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        int K = Integer.parseInt(info[2]);

        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int leafs = (int) Math.pow(2, h);

        arr = new long[N + 1];
        tree = new long[leafs];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        fill(1, N, 1);

        for (int i = 0; i < M + K; i++) {
            String[] info1 = br.readLine().split(" ");
            if (info1[0].equals("1")) {
                int from = Integer.parseInt(info1[1]);
                long to = Long.parseLong(info1[2]);
                long difference = to - arr[Integer.parseInt(info1[1])];
                amend(1, N, from, 1, difference);
                arr[Integer.parseInt(info1[1])] = Long.parseLong(info1[2]);
            } else {
                sum(1, N, Integer.parseInt(info1[1]), Integer.parseInt(info1[2]), 1);
                System.out.println(sum);
                sum = 0;
            }
        }
    }

    private static long fill(int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return tree[index];
        }
        int mid = (start + end) / 2;
        tree[index] = fill(start, mid, index * 2) + fill(mid + 1, end, index * 2 + 1);
        return tree[index];
    }

    private static void amend(int start, int end, int arrIndex, int index, long difference) {
        if (start <= arrIndex && arrIndex <= end) {
            tree[index] = tree[index] + difference;
        } else return;

        if (start == end) return;

        int mid = (start + end) / 2;
        amend(start, mid, arrIndex, index * 2, difference);
        amend(mid + 1, end, arrIndex, index * 2 + 1, difference);
    }

    private static void sum(int start, int end, int sumStart, int sumEnd, int index) {
        if (start == sumStart && end == sumEnd) {
            sum += tree[index];
            return;
        }
        int mid = (start + end) / 2;
        if (sumStart <= mid) {
            if (mid < sumEnd) {
                sum(start, mid, sumStart, mid, index * 2);
                sum(mid + 1, end, mid + 1, sumEnd, index * 2 + 1);
            } else {
                sum(start, mid, sumStart, sumEnd, index * 2);
            }
        } else {
            sum(mid + 1, end, sumStart, sumEnd, index * 2 + 1);
        }
    }
}
