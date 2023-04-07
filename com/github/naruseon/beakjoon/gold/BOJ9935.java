package com.github.naruseon.beakjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문자열 폭발, gold 4

public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();
        char[] str_char = str.toCharArray();
        StringBuilder curState = new StringBuilder();

        for (char c : str_char) {
            curState.append(c);
            int curLength = curState.length();
            if (curLength >= bomb.length()) {
                if (curState.substring(curLength - bombLength, curLength).equals(bomb)) {
                    curState.delete(curLength - bombLength, curLength);
                }
            }
        }

        System.out.println((curState.length() > 0) ? curState : "FRULA");
    }
}
