package com.github.naruseon.beakjoon.gold;

import java.math.BigInteger;
import java.util.Scanner;

// 피보나치 수 6, gold 2

public class BOJ11444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong() - 1;
        BigInteger prime = new BigInteger("1000000007");
        BigInteger[][] base = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        BigInteger[][] base_temp = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};
        BigInteger[][] ans = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
        BigInteger[][] ans_temp = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
        while (n > 0) {
            if ((n & 1) == 0) {
                base[0][0] = (base_temp[0][0].multiply(base_temp[0][0]).add(base_temp[0][1].multiply(base_temp[1][0]))).mod(prime);
                base[0][1] = (base_temp[0][0].multiply(base_temp[0][1]).add(base_temp[0][1].multiply(base_temp[1][1]))).mod(prime);
                base[1][0] = (base_temp[1][0].multiply(base_temp[0][0]).add(base_temp[1][1].multiply(base_temp[1][0]))).mod(prime);
                base[1][1] = (base_temp[1][0].multiply(base_temp[0][1]).add(base_temp[1][1].multiply(base_temp[1][1]))).mod(prime);
                base_temp[0][0] = base[0][0];
                base_temp[0][1] = base[0][1];
                base_temp[1][0] = base[1][0];
                base_temp[1][1] = base[1][1];
                n >>= 1;
            } else {
                ans[0][0] = (ans_temp[0][0].multiply(base[0][0]).add(ans_temp[0][1].multiply(base[1][0]))).mod(prime);
                ans[0][1] = (ans_temp[0][0].multiply(base[0][1]).add(ans_temp[0][1].multiply(base[1][1]))).mod(prime);
                ans[1][0] = (ans_temp[1][0].multiply(base[0][0]).add(ans_temp[1][1].multiply(base[1][0]))).mod(prime);
                ans[1][1] = (ans_temp[1][0].multiply(base[0][1]).add(ans_temp[1][1].multiply(base[1][1]))).mod(prime);
                ans_temp[0][0] = ans[0][0];
                ans_temp[0][1] = ans[0][1];
                ans_temp[1][0] = ans[1][0];
                ans_temp[1][1] = ans[1][1];
                n -= 1;
            }
        }
        System.out.println(ans[0][0]);
    }
}
