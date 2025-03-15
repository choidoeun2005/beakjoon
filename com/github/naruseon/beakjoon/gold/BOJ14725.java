package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ14725 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node head = new Node();
        Node curpos;

        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            int M = Integer.parseInt(info[0]);
            curpos = head;
            for (int j = 1; j <= M; j++) {
                if (!curpos.children.containsKey(info[j])) {
                    curpos.addChild(info[j], new Node());
                }
                curpos = curpos.children.get(info[j]);
            }
        }

        dfs(head, 0);
    }

    public static void dfs(Node head, int depth) {
        for (String s : head.children.keySet()) {
            for (int i = 0; i < depth; i++)
                System.out.print("--");
            System.out.println(s);
            dfs(head.children.get(s), depth + 1);
        }
    }

    private static class Node {
        TreeMap<String, Node> children = new TreeMap<>();

        public Node(){}

        public void addChild(String s, Node node) {
            children.put(s, node);
        }
    }
}
