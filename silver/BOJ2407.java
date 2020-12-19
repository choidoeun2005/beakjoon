package com.github.naruseon.beakjoon;

import java.math.BigInteger;
import java.util.*;

// а╤гу, silver 2

public class BOJ2407 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger N = BigInteger.ONE;
		BigInteger M = BigInteger.ONE;
		BigInteger K = BigInteger.ONE;
		
		for (int i = 2; i <= n; i++) {
			N = N.multiply(BigInteger.valueOf(i));
		}
		for (int i = 2; i <= m; i++) {
			M = M.multiply(BigInteger.valueOf(i));
		}
		for (int i = 2; i <= n - m; i++) {
			K = K.multiply(BigInteger.valueOf(i));
		}
		System.out.println(N.divide(M).divide(K));
	}
}
