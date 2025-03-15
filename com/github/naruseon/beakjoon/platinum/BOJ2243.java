package com.github.naruseon.beakjoon.platinum;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2243 {
    static int[] tree;
    static int[] indexes;
    static boolean[] accessible;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = 1_000_000;
        int h = (int) Math.ceil(Math.log(T) / Math.log(2));
        indexes = new int[T];
        tree = new int[1 << (h + 1)];
        accessible = new boolean[1 << (h + 1)];

        get_index(0, 0, T - 1);

//        System.out.println(Arrays.toString(accessible));

        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(tree));
            int state = sc.nextInt();
            if (state == 1) {
                pop(0, 0, T - 1, sc.nextInt());
            } else {
                int taste = sc.nextInt() - 1;
                int amount = sc.nextInt();

                int index = indexes[taste];
                while (index > 0) {
                    tree[index] += amount;
                    index = (index - 1) / 2;
                }
            }
        }

//        System.out.println(Arrays.toString(indexes));
    }

    public static void get_index(int index, int start, int end) {
        accessible[index] = true;
        if (start == end) {
            indexes[start] = index;
            return;
        }
        int mid = (start + end) / 2;
        get_index(index * 2 + 1, start, mid);
        get_index(index * 2 + 2, mid + 1, end);
    }

    public static void pop(int index, int start, int end, int taste_rank) {
//        System.out.println("start" + start + "end" + end);
        boolean stop = false;
        if (index * 2 + 1 >= tree.length) {
            stop = true;
        }
        else if (!accessible[index * 2 + 1]) {
            stop = true;
        }

        if (stop) {
            System.out.println(start + 1);
            while (index > 0) {
                tree[index]--;
                index = (index - 1) / 2;
            }
            return;
        }

        int left_amount = tree[index * 2 + 1];
        int mid = (start + end) / 2;
//        System.out.println(taste_rank + " " + left_amount);
        if (taste_rank > left_amount) {
            pop(index * 2 + 2, mid + 1, end, taste_rank - left_amount);
        } else{
            pop(index * 2 + 1, start, mid, taste_rank);
        }
    }
}
