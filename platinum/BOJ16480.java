package com.github.naruseon.beakjoon.platinum;

import java.util.Scanner;

// 외심과 내심은 사랑입니다, platinum 3

public class BOJ16480 {
    public static void main(String[] args) {
        // 오일러의 삼각형 정리 이용
        Scanner sc = new Scanner(System.in);
        long R = sc.nextLong();
        long r = sc.nextLong();
        System.out.println(R * (R - 2 * r));
    }
}
