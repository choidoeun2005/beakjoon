package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이진 검색 트리, gold 5

public class BOJ5639 {
    static int[] tree = new int[10000];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String next = br.readLine();
        int i = 0;
        while (!(next == null)) {
            tree[i] = Integer.parseInt(next);
            next = br.readLine();
            i++;
        }

        solve(0, i - 1);
        System.out.println(sb);
    }

    static void solve(int start, int end) {
        if (start == end) {
            sb.append(tree[start]).append("\n");
            return;
        }

        int root = tree[start];
        int split = start; // root 보다 작은건 split 의 왼쪽에 있음
        for (int i = start + 1; i <= end; i++) {
            if (tree[i] > root) {
                split = i;
                break;
            }
        }

        // 좌측 탐색
        if (split > start + 1) {
            // split = start + 1이라면 우측밖에 없음
            // 좌측이 달려있으려면 split > start + 1이어야 함
            solve(start + 1, split - 1);
        }
        // 우측 탐색
        if (split == start || split == start + 1) // 좌 또는 우에만 달려있어서 split 불가능하다면
            solve(start + 1, end);
        else solve(split, end);

        sb.append(root).append("\n");
    }
}
