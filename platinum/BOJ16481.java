package com.github.naruseon.beakjoon.platinum;

import java.util.Scanner;

// 원 전문가 진우, platinum 4

public class BOJ16481 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        System.out.println((a * b * c) / (a * b + b * c + c * a));
    }
}
