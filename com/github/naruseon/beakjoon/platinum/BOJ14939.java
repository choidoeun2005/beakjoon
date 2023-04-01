package com.github.naruseon.beakjoon.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 불 끄기, platinum 4

public class BOJ14939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] state = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                state[i][j] = br.read() == 'O';
            }
            br.read();
        }

        short bit = 0b0000_0000_0000_0000;
        while (bit <= 1023) {
            int pressCnt = 0;
            boolean[][] stateCopy = new boolean[10][10];
            for (int i = 0; i < 10; i++) {
                System.arraycopy(state[i], 0, stateCopy[i], 0, 10);
            }
            short bitCopy = bit;
            for (int i = 0; i < 10; i++) { // 첫째줄 완전탐색
                if ((bitCopy & 1) == 1) {
                    pressCnt++;
                    stateCopy[0][i] = !stateCopy[0][i]; // 중
                    if (i > 0) stateCopy[0][i - 1] = !stateCopy[0][i - 1]; // 좌
                    if (i < 9) stateCopy[0][i + 1] = !stateCopy[0][i + 1]; // 우
                    stateCopy[1][i] = !stateCopy[1][i]; // 하
                }
                bitCopy >>= 1;
            }
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (stateCopy[i - 1][j]) {
                        pressCnt++;
                        stateCopy[i][j] = !stateCopy[i][j]; // 중
                        stateCopy[i - 1][j] = !stateCopy[i - 1][j]; // 상
                        if (i < 9) stateCopy[i + 1][j] = !stateCopy[i + 1][j]; // 하
                        if (j > 0) stateCopy[i][j - 1] = !stateCopy[i][j - 1]; // 좌
                        if (j < 9) stateCopy[i][j + 1] = !stateCopy[i][j + 1]; // 우
                    }
                }
            }

            boolean pass = true;
            for (boolean b : stateCopy[9]) {
                pass &= !b;
            }

            if (pass) {
                System.out.println(pressCnt);
                return;
            }

            bit++;
        }
        System.out.println(-1);
    }
}
