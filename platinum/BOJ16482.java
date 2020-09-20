package com.github.naruseon.beakjoon.platinum;

// 한 점에서 만나라!, platinum 3

import java.util.Scanner;

public class BOJ16482 {
    public static void main(String[] args) {
        // 체바정리 이용
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();

        double ans = (b * (a - e) * (c - d)) / (a * c - a * d - c * e + 2 * d * e);
        System.out.println(ans);

    }
}
