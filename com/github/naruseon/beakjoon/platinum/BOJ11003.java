package com.github.naruseon.beakjoon.platinum;

import java.util.*;
import java.io.*;

public class BOJ11003 {
    public static void main(String[] args) throws IOException {
        Deque<int[]> deque = new ArrayDeque<>();
        FastReader fr = new FastReader();
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = fr.nextInt();
        int L = fr.nextInt();

        for (int i = 0; i < N; i++) {
            int cur = fr.nextInt();
            if (i >= L) {
                if (deque.peek()[0] == i - L)
                    deque.removeFirst();
            }

            if (deque.isEmpty()) deque.offer(new int[] {i, cur});
            else {
                if (deque.peekLast()[1] < cur)
                    deque.offer(new int[] {i, cur});
                else {
                    while (true) {
                        deque.removeLast();
                        if (deque.isEmpty()) break;
                        if (deque.peekLast()[1] < cur) break;
                    }
                    deque.offer(new int[] {i, cur});
                }
            }
            br.write(String.valueOf(deque.peek()[1]));
            if (i != N - 1)
                br.write(" ");
        }
        br.flush();
        br.close();
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}
