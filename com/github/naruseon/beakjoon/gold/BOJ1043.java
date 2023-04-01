package com.github.naruseon.beakjoon.gold;

import java.io.*;
import java.util.*;

// 거짓말, gold 4

public class BOJ1043 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int N = fr.nextInt();
        int M = fr.nextInt();
        int avoidPersonNum = fr.nextInt();
        int[] initialAvoidPerson = new int[avoidPersonNum];
        ArrayList<Integer> avoidPerson = new ArrayList<>();
        for (int i = 0; i < avoidPersonNum; i++) {
            initialAvoidPerson[i] = fr.nextInt() - 1;
        }

        boolean[][] graph = new boolean[N][N];
        ArrayList<Integer>[] partyByPeople = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            partyByPeople[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int j = fr.nextInt();
            int[] curPerson = new int[j];
            for (int k = 0; k < j; k++) {
                curPerson[k] = fr.nextInt() - 1;
            }
            for (int a1 = 0; a1 < j; a1++) {
                int a1_person = curPerson[a1];
                for (int a2 = a1; a2 < j; a2++) {
                    int a2_person = curPerson[a2];
                    graph[a1_person][a2_person] = true;
                    graph[a2_person][a1_person] = true;
                }
            }
            for (int a1 = 0; a1 < j; a1++) {
                partyByPeople[curPerson[a1]].add(i);
            }
        }

        boolean[] visited = new boolean[N];

        for (int i : initialAvoidPerson) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (visited[cur]) continue;
                avoidPerson.add(cur);
                visited[cur] = true;
                for (int j = 0; j < N; j++) {
                    if (graph[cur][j]) {
                        queue.add(j);
                    }
                }
            }
        }

        boolean[] canAttend = new boolean[M];
        Arrays.fill(canAttend, true);
        for (int i : avoidPerson) {
            ArrayList<Integer> cannotAttend = partyByPeople[i];
            for (int j : cannotAttend) {
                canAttend[j] = false;
            }
        }

        int canAttendCnt = 0;
        for (boolean b : canAttend) {
            if (b) canAttendCnt++;
        }

        System.out.println(canAttendCnt);
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
