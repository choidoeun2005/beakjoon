package com.github.naruseon.beakjoon.platinum;

import java.util.Scanner;

public class BOJ1019 {
    public static void main(String[] args) {
        long[] arr = new long[10];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dig = 0;
        while (n >= 10) {
            while (n % 10 != 9) {
                int temp = n;
                while (temp > 0) {
                    arr[temp % 10] += (long) Math.pow(10, dig);
                    temp /= 10;
                }
                n--;
            }
            if (n != 9) {
                for (int i = 0; i < arr.length; i++) {
                    arr[i] += ((n / 10) + 1) * Math.pow(10, dig);
                }
                arr[0] -= Math.pow(10, dig);
                dig++;
                n /= 10;
            }
        }

        for (int i = 1; i <= n; i++)
            arr[i] += Math.pow(10, dig);


        for (long i : arr)
            System.out.print(i + " ");
    }
}
