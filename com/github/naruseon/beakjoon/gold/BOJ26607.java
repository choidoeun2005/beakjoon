package com.github.naruseon.beakjoon.gold;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ26607 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        int selection = sc.nextInt();
        double sum = sc.nextDouble();
        double pivot = sum / 2;
        Person[] people = new Person[P];
        for (int i = 0; i < P; i++) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            Person person = new Person(a, b, 0);
            people[i] = person;
        }

        for (int i = 0; i < P; i++) {
            people[i].diff = Math.abs(pivot - people[i].a);
        }
        Arrays.sort(people, Comparator.comparingDouble(o -> o.diff));
        double a = 0;
        double b = 0;
        for (int i = 0; i < selection; i++) {
            a += people[i].a;
            b += people[i].b;
        }
        System.out.println(a * b);
    }

    static class Person{
        double a;
        double b;
        double diff;
        public Person(double a, double b, double diff){
            this.a = a;
            this.b = b;
            this.diff = diff;
        }
    }
}
