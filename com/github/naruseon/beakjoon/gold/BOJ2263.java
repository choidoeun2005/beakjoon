package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 트리의 순회, gold 2

public class BOJ2263 {

    static int[] inorder = new int[100000];
    static int[] postorder = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st_inorder = new StringTokenizer(br.readLine());
        StringTokenizer st_postorder = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st_inorder.nextToken());
            postorder[i] = Integer.parseInt(st_postorder.nextToken());
        }

        solve(0, n - 1, 0, n - 1);
    }

    static void solve(int in_start, int in_end, int post_start, int post_end) {
        int root = postorder[post_end];
        System.out.print(root + " ");
        int in_index = inIndex(root, in_start, in_end);
        if (!(in_start == in_end)) {
            if (in_index - 1 >= in_start) { // 해당 노드에 좌측 트리가 붙어 있을 경우
                int left_tree_cap = in_index - in_start;
                solve(in_start, in_index - 1, post_start, post_start + left_tree_cap - 1);
            }
            if (in_index + 1 <= in_end) { // 해당 노드에 우측 트리가 붙어 있을 경우
                int right_tree_cap = in_end - in_index;
                solve(in_index + 1, in_end, post_end - right_tree_cap, post_end - 1);
            }
        }
    }

    static int inIndex(int value, int in_start, int in_end) {
        for (int i = in_start; i <= in_end; i++) {
            if (inorder[i] == value) return i;
        }
        return -1;
    }
}

