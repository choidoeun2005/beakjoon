package com.github.naruseon.beakjoon.diamond;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

// 삼각형 해커, diamond 5

import static java.math.BigDecimal.ROUND_HALF_UP;

public class BOJ16489 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigDecimal a = sc.nextBigDecimal();
        BigDecimal b = sc.nextBigDecimal();
        BigDecimal c = sc.nextBigDecimal();
        BigDecimal s = a.add(b).add(c).multiply(BigDecimal.valueOf(0.5));
        BigDecimal S = sqrt(s.multiply(s.subtract(a)).multiply(s.subtract(b)).multiply(s.subtract(c)), 30);
        BigDecimal R = a.multiply(b).multiply(c).divide(S.multiply(BigDecimal.valueOf(4)), MathContext.DECIMAL64);
        BigDecimal r = S.multiply(BigDecimal.valueOf(2)).divide(a.add(b).add(c), MathContext.DECIMAL64);

        BigDecimal d;
        if (a.equals(b) && b.equals(c))
            d = BigDecimal.ZERO;
        else d = sqrt(R.multiply(R.subtract(r.multiply(BigDecimal.valueOf(2)))), 30);
        BigDecimal k = sqrt(R.multiply(R).subtract(a.divide(BigDecimal.valueOf(2), MathContext.DECIMAL64).multiply(a.divide(BigDecimal.valueOf(2), MathContext.DECIMAL64))), 30)
                .add(sqrt(R.multiply(R).subtract(b.divide(BigDecimal.valueOf(2), MathContext.DECIMAL64).multiply(b.divide(BigDecimal.valueOf(2), MathContext.DECIMAL64))), 30))
                .add(sqrt(R.multiply(R).subtract(c.divide(BigDecimal.valueOf(2), MathContext.DECIMAL64).multiply(c.divide(BigDecimal.valueOf(2), MathContext.DECIMAL64))), 30));

        System.out.println(S);
        System.out.println(R);
        System.out.println(r);
        System.out.println(d);
        System.out.println(k);
    }

    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = BigDecimal.valueOf(Math.sqrt(A.doubleValue()));
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(BigDecimal.valueOf(2), SCALE, ROUND_HALF_UP);

        }
        return x1;
    }
}


