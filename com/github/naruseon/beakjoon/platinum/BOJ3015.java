package com.github.naruseon.beakjoon.platinum;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ3015 {
    static ArrayList<Pair> arr = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] people = new long[N];
        for (int i = 0; i < N; i++) {
            people[i] = sc.nextLong();
        }

        long ans = 0;
        arr.add(new Pair(people[0], 1));

        for (int i = 1; i < people.length; i++) {
            ans += search(people[i]);
        }
//        arr.forEach(p -> System.out.print("(" + p.height + " " + p.same + ")"));
//        System.out.println();

        System.out.println(ans);
    }

    public static long search(long cur_height) {
//        arr.forEach(p -> System.out.print("(" + p.height + " " + p.same + ")"));
//        System.out.println();
        long viewable = 0;
        int l = 0;
        int r = arr.size();
        int original_size = arr.size();
        int mid = (l + r) / 2;
        while (r != l) {
            long comp = arr.get(mid).height;
//            System.out.println(comp + " " + cur_height);
            if (comp > cur_height) {
                l = mid + 1;
                mid = (l + r) / 2;
            } else if (comp == cur_height) {
                for (int i = mid; i < original_size; i++) {
                    viewable += arr.get(i).same;
                }
                if (mid > 0)
                    viewable += 1;
                for (int i = mid + 1; i < original_size; i++) {
                    arr.remove(arr.size() - 1);
                }
                arr.get(mid).same += 1;
                return viewable;
            } else {
                r = mid;
                mid = (l + r) / 2;
            }
        }

        for (int i = r; i < arr.size(); i++) {
            viewable += arr.get(i).same;
        }
        if (r > 0)
            viewable += 1;
        for (int i = r + 1; i < original_size; i++) {
//            System.out.println("removing: " + arr.get(arr.size() - 1).height);
            arr.remove(arr.size() - 1);
        }
        if (r < arr.size())
            arr.set(r, new Pair(cur_height, 1));
        else
            arr.add(new Pair(cur_height, 1));
        return viewable;
    }

    static class Pair {
        long height;
        int same;

        Pair(long height, int same) {
            this.height = height;
            this.same = same;
        }
    }
}
