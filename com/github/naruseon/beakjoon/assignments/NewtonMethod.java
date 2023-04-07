package com.github.naruseon.beakjoon.assignments;

public class NewtonMethod {
    static double Function1(double x) {
        return (x*x-2);
    }

    static double Function2(double x) {
        return (2*x);
    }

    public static void main(String[] args) {
        System.out.println("Newton method");

        double tolerance = 0.000000001;
        double x = 2;

        while( (Function1(x)/Function2(x) ) > tolerance )
        {
            x = x - (Function1(x) / Function2(x));
            System.out.println("in loop " + x);
        }

        System.out.println("result : "+ x);

    }
}
