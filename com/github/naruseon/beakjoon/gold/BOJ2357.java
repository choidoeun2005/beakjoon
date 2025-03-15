package com.github.naruseon.beakjoon.gold;

import java.io.*;

public class BOJ2357 {
    static int[] minTree;
    static int[] maxTree;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        arr = new int[N + 1];
        int leafs = (int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))) * 2;
        minTree = new int[leafs];
        maxTree = new int[leafs];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        minInit(1, N, 1);
        maxInit(1, N, 1);
        for (int i = 0; i < M; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            findMin(1, N, a, b, 1);
            findMax(1, N, a, b, 1);
            bw.write(min + " " + max);
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            if (i != M - 1) bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    private static int minInit(int start, int end, int index) {
        if (start == end) {
            minTree[index] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        minTree[index] = Math.min(minInit(start, mid, index * 2), minInit(mid + 1, end, index * 2 + 1));
        return minTree[index];
    }

    private static int maxInit(int start, int end, int index) {
        if (start == end) {
            maxTree[index] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        maxTree[index] = Math.max(maxInit(start, mid, index * 2), maxInit(mid + 1, end, index * 2 + 1));
        return maxTree[index];
    }

    private static void findMin(int start, int end, int l, int r, int index) {
//        System.out.printf("min : %d %d %d %d %d\n", start, end, l, r, index);
        if (start == l && end == r) {
//            System.out.printf("match : %d %d %d %d %d -> %d\n", start, end, l, r, index, minTree[index]);
            min = Math.min(min, minTree[index]);
            return;
        }
        int mid = (start + end) / 2;
        if (l <= mid) {
            if (mid < r) {
                findMin(start, mid, l, mid, index * 2);
                findMin(mid + 1, end, mid + 1, r, index * 2 + 1);
            } else {
                findMin(start, mid, l, r, index * 2);
            }
        } else findMin(mid + 1, end, l, r, index * 2 + 1);
    }

    private static void findMax(int start, int end, int l, int r, int index) {
        if (start == l && end == r) {
            max = Math.max(max, maxTree[index]);
            return;
        }
        int mid = (start + end) / 2;
        if (l <= mid) {
            if (mid < r) {
                findMax(start, mid, l, mid, index * 2);
                findMax(mid + 1, end, mid + 1, r, index * 2 + 1);
            } else {
                findMax(start, mid, l, r, index * 2);
            }
        } else findMax(mid + 1, end, l, r, index * 2 + 1);
    }
}
