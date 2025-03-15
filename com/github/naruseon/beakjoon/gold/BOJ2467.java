package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int left = 0, right = N - 1;
        int cur = Integer.MAX_VALUE;
        int ans_left = 0, ans_right = 0;
        while (left < right) {
            int temp = Integer.parseInt(arr[left]) + Integer.parseInt(arr[right]);
            if (Math.abs(cur) > Math.abs(temp)) {
                cur = temp;
                ans_left = left;
                ans_right = right;
            }
            if (temp > 0) right--;
            else left++;
        }

        System.out.println(arr[ans_left] + " " + arr[ans_right]);
    }
}
