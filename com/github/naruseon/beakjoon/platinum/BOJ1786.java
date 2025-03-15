package com.github.naruseon.beakjoon.platinum;

import java.util.Scanner;

public class BOJ1786 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] text = sc.nextLine().split("");
        String[] pattern = sc.nextLine().split("");

        int i = 1;
        int j = 0;
        int len = pattern.length;
        int[] F = new int[len];
        F[0] = 0;

        while (i < len) {
            if (pattern[i].equals(pattern[j])) {
                F[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = F[j - 1];
            } else {
                i++;
            }
        }

//        for (int a : F) {
//            System.out.print(a + " ");
//        }
//        System.out.println();

        i = 0;
        j = 0;
        int N = 0;
        StringBuilder pos = new StringBuilder();

        while (i < text.length) {
            if (text[i].equals(pattern[j])) {
                i++;
                j++;
                if (j == len) {
                    N++;
                    pos.append(i - len + 1).append(" ");
                    j = F[j - 1];
                }
            } else if (j > 0) {
                j = F[j - 1];
            } else {
                i++;
            }
        }

        System.out.println(N);
        System.out.println(pos);
    }
}
