package com.github.naruseon.beakjoon.assignments;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int N = 10;
        int K = 4;
        while (N-- > 0) {
            System.out.println(N);
            if (--K == 0) break;
        }
        System.out.println(N);
    }
}
