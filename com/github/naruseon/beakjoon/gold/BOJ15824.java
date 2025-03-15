package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ15824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long[] pow = new long[N];
        long p = 1_000_000_007;
        pow[0] = 1;
        for (int i = 1; i < N; i++) {
            pow[i] = (pow[i - 1] * 2) % p;
        }
        String[] info = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }

        Arrays.sort(arr);

        long ans = 0;

        for (int i = 0; i < N; i++) {
//            System.out.println("\ni = " + i);
//            System.out.println((-arr[i] + arr[N - i - 1]) % p);
//            System.out.println(pow[N - i - 1]);
            ans += ((((-arr[i] + arr[N - i - 1]) % p) * pow[N - i - 1]) % p);
            ans %= p;
//            System.out.println(ans);
        }
//        System.out.println("\n ans :");
        System.out.println((ans >= 0) ? ans : p + ans);
    }
}
