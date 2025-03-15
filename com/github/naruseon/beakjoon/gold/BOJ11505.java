package com.github.naruseon.beakjoon.gold;

import java.io.*;
import java.util.Arrays;

public class BOJ11505 {
    static int[] arr;
    static long[] tree;
    static int p = 1_000_000_007;
    static long ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        int K = Integer.parseInt(info[2]);

        arr = new int[N + 1];
        int leafs = (int) Math.pow(2, Math.ceil(Math.log(N)/Math.log(2))) * 2;
        tree = new long[leafs];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        init(1, N, 1);
        for (int i = 0; i < M + K; i++) {
            String[] temp = br.readLine().split(" ");
            if (temp[0].equals("1")) {
                int from = Integer.parseInt(temp[1]);
                int to = Integer.parseInt(temp[2]);
                update(1, N, from, to, 1);
            } else {
                int a = Integer.parseInt(temp[1]);
                int b = Integer.parseInt(temp[2]);
                calculate(1, N, a, b, 1);
                bw.write(ans + "");
                bw.newLine();
                ans = 1;
            }
        }
        bw.flush();
        bw.close();
    }

    private static long init(int start, int end, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        tree[index] = init(start, mid, index * 2) * init(mid + 1, end, index * 2 + 1) % p;
        return tree[index];
    }

    private static void update(int start, int end, int arrIndex, int value, int index) {
        if (start == end && end == arrIndex) {
            tree[index] = value;
            while (index > 1) {
                if (index % 2 == 0) {
                    tree[index >> 1] = tree[index] * tree[index + 1] % p;
                } else tree[index >> 1] = tree[index] * tree[index - 1] % p;

                index >>= 1;
            }
            return;
        }
        int mid = (start + end) / 2;
        if (arrIndex <= mid) update(start, mid, arrIndex, value, index * 2);
        else update(mid + 1, end, arrIndex, value, index * 2 + 1);
    }

    private static void calculate(int start, int end, int l, int r, int index) {
        if (start == l && end == r) {
            ans *= tree[index];
            ans %= p;
            return;
        }
        int mid = (start + end) / 2;
        if (l <= mid) {
            if (mid < r) {
                calculate(start, mid, l, mid, index * 2);
                calculate(mid + 1, end, mid + 1, r, index * 2 + 1);
            } else calculate(start, mid, l, r, index * 2);
        } else calculate(mid + 1, end, l, r, index * 2 + 1);
    }
}
