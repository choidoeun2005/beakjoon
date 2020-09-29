package com.github.naruseon.beakjoon.silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// AC, silver 2

public class BOJ5430 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        boolean rotated;
        int N = sc.nextInt();
        outer:
        for (int i = 0; i < N; i++) {
            rotated = false;
            char[] cmd = sc.next().toCharArray();
            int len = sc.nextInt();
            ArrayList <Integer> arr = new ArrayList<>();
            String[] info = sc.next().split(",");
            info[0] = info[0].substring(1);
            info[info.length - 1] = info[info.length - 1].substring(0, info[info.length - 1].length() - 1);
            for (String s : info) {
                if (!s.equals(""))
                    arr.add(Integer.parseInt(s));
            }

            for (char c : cmd) {
                if (c == 'R') {
                    rotated = !rotated;
                }
                if (c == 'D') {
                    try {
                        if (rotated) arr.remove(arr.size() - 1);
                        else arr.remove(0);
                    } catch (Exception e) {
                        sb.append("error").append("\n");
                        continue outer;
                    }
                }
            }
            if (arr.size() == 0) {
                sb.append("[]\n");
                continue;
            }
            if (rotated) Collections.reverse(arr);
            sb.append("[");
            for (int j = 0; j < arr.size() - 1; j++) {
                sb.append(arr.get(j)).append(",");
            }
            sb.append(arr.get(arr.size() - 1)).append("]").append("\n");
        }
        System.out.println(sb.toString());
    }
}
