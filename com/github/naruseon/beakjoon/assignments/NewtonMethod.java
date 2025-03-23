package com.github.naruseon.beakjoon.assignments;

import java.util.ArrayList;

public class NewtonMethod {
    public static void main(String[] args) {
        A a = new A();
        a.addElement(1);
        a.addElement(2);
//        A b = new A();
//        a = b;
        a.list.forEach(System.out :: println);

    }

    static class A {
        ArrayList<Integer> list = new ArrayList<>();
        public A() {}

        public void addElement(int a) {
            list.add(a);
        }
    }
}
