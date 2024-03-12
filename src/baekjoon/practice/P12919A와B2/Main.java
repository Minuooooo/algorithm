package baekjoon.practice.P12919A와B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        StringBuilder sb = new StringBuilder();
        System.out.println(generateStr(T));
    }

    private static int generateStr(String str) {
        if (str.length() == S.length()) {
            if (str.equals(S))
                return 1;
            return 0;
        }
        int result = 0;
        if (str.charAt(0) == 'B') {
            String subStr = str.substring(1);
            StringBuilder sb = new StringBuilder(subStr);
            subStr = sb.reverse().toString();
            result += generateStr(subStr);
        }
        if (str.charAt(str.length() - 1) == 'A') {
            String subStr = str.substring(0, str.length() - 1);
            result += generateStr(subStr);
        }
        return result > 0 ? 1 : 0;
    }
}