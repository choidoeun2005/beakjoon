package com.github.naruseon.beakjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

// 트리 순회, silver 1

public class BOJ1991 {
    static Node[] nodes;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        nodes = new Node[100];
        Arrays.fill(nodes, new Node((char) 0, (char) 0, (char) 0));
        // 65 = A
        for (int i = 0; i < N; i++) {
            char parent = sc.next().charAt(0);
            char left = sc.next().charAt(0);
            char right = sc.next().charAt(0);
            nodes[parent] = new Node(parent, left, right);
        }

        preOrder(nodes['A']);
        System.out.println();
        inOrder(nodes['A']);
        System.out.println();
        postOrder(nodes['A']);
    }

    public static void preOrder(Node parent) {
        if (parent.self == 0) return;
        System.out.print(parent.self);
        preOrder(nodes[parent.left]);
        preOrder(nodes[parent.right]);
    }

    public static void inOrder(Node parent) {
        if (parent.self == 0) return;
        inOrder(nodes[parent.left]);
        System.out.print(parent.self);
        inOrder(nodes[parent.right]);
    }

    public static void postOrder(Node parent) {
        if (parent.self == 0) return;
        postOrder(nodes[parent.left]);
        postOrder(nodes[parent.right]);
        System.out.print(parent.self);
    }

    static class Node {
        char self;
        char left = 0;
        char right = 0;

        public Node(char self, char left, char right) {
            this.self = self;
            if (left != '.')
                this.left = left;
            if (right != '.')
                this.right = right;
        }
    }
}
