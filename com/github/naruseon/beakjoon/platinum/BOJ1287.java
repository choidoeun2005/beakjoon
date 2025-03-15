package com.github.naruseon.beakjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 할 수 있다, platinum 5
// TODO

public class BOJ1287 {

    static Stack<Integer> operandStack = new Stack<>();
    static Stack<Operator> operatorStack = new Stack<>();

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        char[] expression = fr.next().toCharArray();

        char[] operators = {'+', '-', '*', '/'};

        StringBuilder curNum = new StringBuilder();
        for (int i = 0; i < expression.length; i++) {

        }
    }

    private void calculate() {

    }

    private static class Operator {
        char exp;
        int priority;

        public Operator(char exp, int priority) {
            this.exp = exp;
            this.priority = priority;
        }
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
    }
}
