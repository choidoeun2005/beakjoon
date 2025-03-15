package com.github.naruseon.beakjoon.platinum;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1708 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Pair> arr = new ArrayList<>();
        Pair p = new Pair(80001, 80001);
        for (int i = 0; i < N; i++) {
            Pair temp = new Pair(sc.nextInt() + 40001, sc.nextInt() + 40001);
            arr.add(temp);
            if (temp.x * temp.x + temp.y * temp.y < p.x * p.x + p.y * p.y) p = temp;
        }

        long Px = p.x;
        long Py = p.y;

        arr.forEach(pair -> {
            pair.x -= Px;
            pair.y -= Py;
        });

        arr.sort((p1, p2) -> {
            if (p1.x == 0) {
                if (p2.x == 0) {
                    return Long.compare(p1.y, p2.y);
                }
                else return 1;
            }
            if (p2.x == 0) return -1;

            return Double.compare((double) p1.y / p1.x, (double) p2.y / p2.x);
        });
//        arr.forEach(pair -> System.out.println(pair.x + " " + pair.y));

        ArrayList<Pair> stack = new ArrayList<>();
        stack.add(arr.get(0));
        stack.add(arr.get(1));
        for (int i = 2; i < N; i++) {
//            stack.forEach(pair -> System.out.println(pair.x + " " + pair.y));
            while (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), arr.get(i)) <= 0) {
                stack.remove(stack.size() - 1);
                if (stack.size() == 1) break;
            }
            stack.add(arr.get(i));
        }

        System.out.println(stack.size());
    }

    static long ccw(Pair pivot, Pair p1, Pair p2) {
        p1 = new Pair(p1.x - pivot.x, p1.y - pivot.y);
        p2 = new Pair(p2.x - pivot.x, p2.y - pivot.y);
        return p1.x * p2.y - p1.y * p2.x;
    }

    static class Pair {
        long x, y;

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
