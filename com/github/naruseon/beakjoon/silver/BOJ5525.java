package com.github.naruseon.beakjoon.silver;

// IOIOI, silver 2

import java.util.Scanner;

public class BOJ5525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int len = sc.nextInt();
        char[] string = sc.next().toCharArray();

        int ans = 0;
        int cnt = 0;

        for (int i = 1; i < len - 1; i++) {
            if (string[i - 1] == 'I' && string[i] == 'O' && string[i + 1] == 'I') {
                cnt++;
                if (cnt == N) {
                    cnt--;
                    ans++;
                }
                i++;
            } else cnt = 0;
        }
        System.out.println(ans);
    }
}
