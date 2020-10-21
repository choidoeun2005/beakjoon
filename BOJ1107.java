package com.github.naruseon.beakjoon;

import java.util.Arrays;
import java.util.Scanner;

// ¸®¸ðÄÁ, gold 5

public class BOJ1107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int des = sc.nextInt();
		int broken_num = sc.nextInt();
		boolean[] broken = new boolean[10];
		Arrays.fill(broken, false);
		for (int i = 0; i < broken_num; i++) {
			broken[sc.nextInt()] = true;
		}
		int ans = Math.abs(des - 100);
		for (int i = 0; i < 1_000_000; i++) {
			int len = check(i, broken);
			if (len > 0) {
				int press = Math.abs(des - i);
				if (ans > len + press) {
					ans = len + press;
				}
			}
		}
		System.out.println(ans);
	}

	public static int check(int des, boolean[] broken) {
		if (des == 0) {
			if (broken[0])
				return 0;
			else
				return 1;
		} else {
			int len = 0;
			while (des > 0) {
				if (broken[des % 10])
					return 0;
				des /= 10;
				len++;
			}
			return len;
		}
	}
}
