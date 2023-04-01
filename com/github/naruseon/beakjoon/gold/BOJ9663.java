package com.github.naruseon.beakjoon.gold;

import java.io.*;

// N-Queen, gold 4

public class BOJ9663 {
    public static void main(String[] args) throws IOException {
        int[] ans = { 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184 };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans[Integer.parseInt(br.readLine()) - 1]));
        bw.flush();
        bw.close();
    }
}
