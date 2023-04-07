package com.github.naruseon.beakjoon.gold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질 2, gold 4

public class BOJ12851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int dest = sc.nextInt();

        if (start == dest) {
            System.out.println("0\n1");
            return;
        }

        int[] dist = new int[100_001];
        Arrays.fill(dist, -1);
        dist[start] = 0;
        int shortestTime = Integer.MAX_VALUE;
        int ways = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, 0));

        boolean addMore = true;

        while (!q.isEmpty()) {
            Pair cur = q.poll();

            if (cur.val - 1 >= 0) {
                if (dist[cur.val - 1] == -1 || dist[cur.val - 1] == dist[cur.val] + 1) {
                    dist[cur.val - 1] = dist[cur.val] + 1;
                    if (cur.val - 1 == dest) {
                        shortestTime = cur.level + 1;
                        addMore = false;
                        ways++;
                    }
                    if (addMore)
                        q.offer(new Pair(cur.val - 1, cur.level + 1));
                }
            }

            if (cur.val + 1 <= 100_000) {
                if (dist[cur.val + 1] == -1 || dist[cur.val + 1] == dist[cur.val] + 1) {
                    dist[cur.val + 1] = dist[cur.val] + 1;
                    if (cur.val + 1 == dest) {
                        shortestTime = cur.level + 1;
                        addMore = false;
                        ways++;
                    }
                    if (addMore)
                        q.offer(new Pair(cur.val + 1, cur.level + 1));
                }
            }

            if (cur.val * 2 <= 100_000) {
                if (dist[cur.val * 2] == -1 || dist[cur.val * 2] == dist[cur.val] + 1) {
                    dist[cur.val * 2] = dist[cur.val] + 1;
                    if (cur.val * 2 == dest) {
                        shortestTime = cur.level + 1;
                        addMore = false;
                        ways++;
                    }
                    if (addMore)
                        q.offer(new Pair(cur.val  * 2, cur.level + 1));
                }
            }
        }

        System.out.println(shortestTime);
        System.out.println(ways);
    }

    private static class Pair {
        int val, level;
        Pair (int val, int level) {
            this.val = val;
            this.level = level;
        }
    }
}
