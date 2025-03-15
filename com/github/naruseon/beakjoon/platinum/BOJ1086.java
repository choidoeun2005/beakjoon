package com.github.naruseon.beakjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1086 {
    static int[] mod_10 = new int[51];
    static String[] org;
    static int[] mods;
    static int N, K;
    static long[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        org = new String[N];
        mods = new int[N];
        for (int i = 0; i < N; i++) {
            org[i] = br.readLine();
        }
        K = Integer.parseInt(br.readLine());
        mod_10[0] = 1;
        for (int i = 0; i < 50; i++) {
            mod_10[i + 1] = mod_10[i] * 10 % K;
        }
        for (int i = 0; i < N; i++) {
            mods[i] = mod(org[i], K);
        }
        DP = new long[1 << N][K];


        DP[0][0] = 1;

        for (int i = 0; i < (1 << N); i++) {
            for (int a = 0; a < K; a++) {
                for (int j = 0; j < N; j++) {
                    if ((i & (1 << j)) == 0) {
                        int rem = (a * mod_10[org[j].length()]) % K + mods[j];
                        rem %= K;
                        DP[i | (1 << j)][rem] += DP[i][a];
                    }
                }
            }
        }


        long fact = 1;
        for (int i = 2; i <= N; i++)
            fact *= i;

        long ans = DP[(1 << N) - 1][0];
        if (ans == 0) {
            System.out.println("0/1");
            return;
        }
        long gcd = gcd(fact, ans);
        fact /= gcd;
        ans /= gcd;
        System.out.println(ans + "/" + fact);


    }

    private static long gcd(long a, long b) {
        while (true) {
            if (a == 0 | b == 0) return a + b;
            if (a > b) a %= b;
            else b %= a;
        }
    }


    private static int mod(String str, int K) {
        int len = str.length();
        int res = 0;
        int temp;
        for (int i = 1; str.length() > 8; i++) {

            temp = Integer.parseInt(str.substring(0, 8));
            str = str.substring(8);
            temp = (temp % K) * mod_10[len - 8 * i];
            temp %= K;
            res += temp;
            res %= K;
        }

        temp = Integer.parseInt(str);

        temp %= K;
        res += temp;
        res %= K;
        return res;
    }
}
