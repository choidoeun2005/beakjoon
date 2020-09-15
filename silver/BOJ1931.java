package com.github.naruseon.beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

// 회의실배정, sliver 2

public class BOJ1931 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Pair1[] arr = new Pair1[num];

        for (int i = 0; i < num; i++) {
            arr[i] = new Pair1(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.end != o2.end) return Integer.compare(o1.end, o2.end);
            else return Integer.compare(o1.start, o2.start);
        });

        int end = arr[0].end;
        int cnt = 1;

        for (int i = 1; i < num; i++) {
            int start = arr[i].start;
            if (start >= end) {
                end = arr[i].end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class Pair1 {
    int start, end;

    public Pair1(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
