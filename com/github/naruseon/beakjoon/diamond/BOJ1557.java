package com.github.naruseon.beakjoon.diamond;

import java.util.Scanner;

// 제곱 ㄴㄴ, diamond 5

public class BOJ1557 {
    static int[] mobius = new int[45001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mobius[1] = 1;
        long N = sc.nextLong();
        // 뫼비우스 함수
        // N이하의 k1, k2, k3...의 배수들 합집합 구하는데
        // m[k1~k3] = 1, m[k1*k2~k2*k3] = -1... 식으로 정해서
        // 배열에 k1,...의 조합의 배수들 더할지 뺄지 저장
        // 한개 곱한건 더하고, 두개 곱한건 빼고... 포함배제의 원리를 저장하는 배열
        for (int i = 1; i <= 45000; i++) {
            for (int j = i * 2; j <= 45000; j += i) {
                mobius[j] -= mobius[i];
            }
        }

        long ans = 0;
        // K보다 작은 제곱ㄴㄴ수 개수로 이분탐색
        long left = 0;
        long right = N * 2;
        while (left < right - 1) {
            long mid = (left + right) / 2;
            if (countSquareFree(mid) < N) // 이때까지 센 제곱ㄴㄴ수가 부족하면 left 늘리고
                left = mid;
                // countSquareFree(mid) 개수가 과하면 right 줄이고
                // countSquareFree(mid) 개수가 적당해도 이걸 만족하는 N의 최소가 나와야되기에 right 줄이고 left 놔두고
            else right = mid;
            ans = mid;
        }
        System.out.println(ans);
    }

    static long countSquareFree(long n) {
        long cnt = 0;
        // 포함 배제의 원리 자동화
        // 배수들 더하고 빼는건 배열에 저장되어 있으니, 정보 받아서 더하고 빼는과정만 for문으로 자동화.
        for (long i = 1; i * i <= n; i++) {
            cnt += mobius[(int) i] * (n / (i * i));
        }
        return cnt;
    }
}